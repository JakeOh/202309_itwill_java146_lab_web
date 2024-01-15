package com.itwill.springboot4.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostRepositoryTest {
    
    @Autowired private PostRepository postDao;
    
    @Test
    public void testFindAll() {
        Assertions.assertNotNull(postDao);
        
        List<Post> list = postDao.findAll();
        list.forEach((x) -> log.info(x.toString()));
    }

}
