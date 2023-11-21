package com.itwill.jsp2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.Post;
import com.itwill.jsp2.dto.PostCreateDto;
import com.itwill.jsp2.dto.PostListItemDto;
import com.itwill.jsp2.repository.PostDao;

// Model 2 MVC 아키텍쳐에서 서비스(비즈니스) 계층을 담당하는 클래스.
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    
    // singleton 적용:
    private static PostService instance = null;
    
    private PostDao postDao;
    
    private PostService() {
        postDao = PostDao.getInstance();
    }
    
    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        
        return instance;
    }
    
    public List<PostListItemDto> read() {
        log.info("read()");
        
        // DAO의 메서드를 호출해서 DB POSTS 테이블에서 (아이디 내림차순) 전체 검색.
        List<Post> list =  postDao.select();
        
        // List<Post>를 List<PostListItemDto>로 변환해서 컨트롤러에게 리턴.
        List<PostListItemDto> result = list.stream()
                .map(PostListItemDto::fromPost) // (x) -> PostListItemDto.fromPost(x)
                .toList();
        
        return result;
    }
    
    public void create(PostCreateDto dto) {
        log.debug("crate(dto={})", dto);
        
        // PostCreateDto를 Post 타입으로 변환해서, PostDao의 메서드(insert)를 호출할 때 전달.
        int result = postDao.insert(dto.toPost());
        log.debug("insert result = {}", result);
    }
    
    public Post read(Long id) {
        log.debug("read(id={})", id);
        
        Post post = postDao.select(id);
        log.debug("select result = {}", post);
        
        return post;
    }

}
