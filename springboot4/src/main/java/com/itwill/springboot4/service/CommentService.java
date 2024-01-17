package com.itwill.springboot4.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.Comment;
import com.itwill.springboot4.domain.CommentRepository;
import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.domain.PostRepository;
import com.itwill.springboot4.dto.CommentRegisterRequestDto;

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

    public List<Comment> getCommentList(Long postId) {
        log.info("getCommentList(postId={})", postId);
        
        // 댓글이 달려 있는 포스트 엔터티를 찾음.
        Post post = postDao.findById(postId).orElseThrow();
        
        // 포스트의 댓글 목록을 검색.
        List<Comment> list = commentDao.findByPost(post, Sort.by("id").descending());
        log.info("댓글 개수 = {}", list.size());
        
        return list;
    }
    
}
