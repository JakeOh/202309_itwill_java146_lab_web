package com.itwill.springboot4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.domain.PostRepository;
import com.itwill.springboot4.dto.PostCreateRequestDto;
import com.itwill.springboot4.dto.PostUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostService {
    
    private final PostRepository postDao;

    public Page<Post> getPostList(int page) {
        log.info("getPostList(page={})", page);
        
        Pageable pageable = PageRequest.of(page, 10, Sort.by("id").descending());
        Page<Post> data = postDao.findAll(pageable);
        
        return data;
    }
    
    public Post create(PostCreateRequestDto dto) {
        log.info("create(dto={}", dto);
        
        Post entity = postDao.save(dto.toEntity());
        
        return entity;
    }
    
    public Post readById(Long id) {
        log.info("readById(id={})", id);

        return postDao.findById(id).orElseThrow();
    }
    
    public void deleteById(Long id) {
        log.info("deleteById(id={})", id);
        
        postDao.deleteById(id);
    }

    @Transactional
    //-> 검색한 엔터티의 변화가 생기면 트랜잭션이 종료될 때 update 쿼리가 자동으로 실행.
    public void update(PostUpdateRequestDto dto) {
        log.info("update(dto={})", dto);
        
        Post entity = postDao.findById(dto.getId()).orElseThrow();
        //-> DB에서 저장되어 있는 업데이트 전의 엔터티
        
        entity.update(dto.getTitle(), dto.getContent());
        //-> DB에서 검색한 엔터티의 속성(필드)들의 값을 변경.
        //-> PostRepository.save 메서드를 호출하지 않음.
        //-> @Transactional 애너테이션이 있기 때문에 변경 내용이 자동으로 저장됨!
    }
    
}
