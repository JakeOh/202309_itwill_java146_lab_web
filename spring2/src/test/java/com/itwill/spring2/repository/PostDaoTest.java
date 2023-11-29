package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Logger 객체 생성.
@ExtendWith(SpringExtension.class) // Spring JUnit 테스트를 실행하는 메인 클래스.
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
) // 스프링 컨텍스트(환경 변수) 파일의 경로(이름).
public class PostDaoTest {

    // PostDao 타입 객체를 주입.
    @Autowired private PostDao postDao;
    
    //@Test
    public void selectTest() {
        Assertions.assertNotNull(postDao);
        
        List<Post> list = postDao.selectOrderByIdDesc();
        log.debug("list size = {}", list.size());
        if (list.size() > 0) {
            log.debug(list.get(0).toString());
        }
        
    }
    
//    @Test
    public void selectByIdTest() {
        Post p = postDao.selectById(1); // 테이블에 존재하는 아이디로 검색했을 때
        Assertions.assertNotNull(p);
        log.debug("p={}", p);
        
        p = postDao.selectById(1_000); // 테이블에 존재하지 않는 아이디로 검색했을 때
        Assertions.assertNull(p);
    }
    
    @Test
    public void insertTest() {
        Post post = Post.builder()
                .title("테스트 MyBatis")
                .content("11/29 MyBatis 테스트")
                .author("admin")
                .build();
        int result = postDao.insert(post);
        Assertions.assertEquals(1, result);
    }
    
}
