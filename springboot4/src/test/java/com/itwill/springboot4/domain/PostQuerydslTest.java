package com.itwill.springboot4.domain;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class PostQuerydslTest {
    
    @Autowired private PostRepository postDao;
    
//    @Test
    public void test() {
        Assertions.assertNotNull(postDao);
        
        Post entity = postDao.searchById(310L);
        
        log.info("entity={}", entity);
    }
    
    @Test
    public void test2() {
        List<Post> list = postDao.searchByTitleOrContent("tESt");
        
        list.forEach((p) -> log.info(p.toString()));
    }

}
