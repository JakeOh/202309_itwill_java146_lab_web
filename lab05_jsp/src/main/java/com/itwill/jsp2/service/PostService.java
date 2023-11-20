package com.itwill.jsp2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

}
