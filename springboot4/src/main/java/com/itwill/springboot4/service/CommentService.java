package com.itwill.springboot4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.Comment;
import com.itwill.springboot4.domain.CommentRepository;
import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.domain.PostRepository;
import com.itwill.springboot4.dto.CommentRegisterRequestDto;
import com.itwill.springboot4.dto.CommentUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    
    private final CommentRepository commentDao;
    private final PostRepository postDao;

    public Comment register(CommentRegisterRequestDto dto) {
        log.info("register(dto={})", dto);
        
        // 댓글을 달 포스트 엔터티를 찾음.
        Post post = postDao.findById(dto.getPostId()).orElseThrow();
        
        // DB에 insert할 댓글 엔터티를 생성.
        Comment entity = Comment.builder()
                .post(post)
                .text(dto.getText())
                .writer(dto.getWriter())
                .build();
        
        // DB에 엔터티를 저장: insert 쿼리를 실행.
        commentDao.save(entity);
        
        // 저장된 엔터티를 리턴.
        return entity;
    }

    public Page<Comment> getCommentList(Long postId, int page) {
        log.info("getCommentList(postId={}, page={})", postId, page);
        
        // 댓글이 달려 있는 포스트 엔터티를 찾음.
        Post post = postDao.findById(postId).orElseThrow();
        
        // 포스트의 댓글 목록을 검색. 페이징과 정렬이 적용된 댓글 목록.
        Pageable pageable = PageRequest.of(page, 5, Sort.by("modifiedTime").descending());
        Page<Comment> data = commentDao.findByPost(post, pageable);
        log.info("number={}, total elements={}, total pages={}",
                data.getNumber(), data.getTotalElements(), data.getTotalPages());
        // Page<T>.getNumber(): 현재 페이지 번호
        // Page<T>.getTotalElements(): 전체 원소 개수
        // Page<T>.getTotalPages(): 전체 페이지 개수
        
        return data;
    }

    public void delete(Long id) {
        log.info("delete(id={})", id);
        
        commentDao.deleteById(id);
    }

    @Transactional
    public void update(CommentUpdateRequestDto dto) {
        log.info("update(dto={})", dto);
        
        Comment entity = commentDao.findById(dto.getId()).orElseThrow();
        entity.update(dto.getText());
//        commentDao.save(entity);
    }
    
}
