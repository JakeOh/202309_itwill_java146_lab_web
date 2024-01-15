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
    public void update(PostUpdateRequestDto dto) {
        log.info("update(dto={})", dto);
        
        Post entity = postDao.findById(dto.getId()).orElseThrow();
        entity.update(dto.getTitle(), dto.getContent());
        
    }
    
}
