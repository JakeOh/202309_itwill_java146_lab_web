package com.itwill.springboot4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        String[] keywords = { "TEST", "관리자" };
        Pageable pageable = PageRequest.of(1, 5, Sort.by("id").descending());
        Page<Post> page = postDao.searchByKeywords(keywords, pageable);
        page.forEach((p) -> log.info(p.toString()));
        
//        List<Post> list = 
//                postDao.searchByTitleOrContent("tESt");
//                postDao.searchByModifiedTime(LocalDateTime.of(2024, 1, 15, 17, 0), 
//                        LocalDateTime.of(2024, 1, 15, 18, 0));
//                postDao.searchByKeywordAndAuthor("테스트", "admin");
//                postDao.searchByKeywords(keywords);
        
//        list.forEach((p) -> log.info(p.toString()));
    }

}
