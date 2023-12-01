package com.itwill.spring2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
)
public class CommentDaoTest {
    
    // 리포지토리 객체를 주입받음(의존성 주입 DI, 제어의 역전 IoC)
    @Autowired private CommentDao commentDao;

    @Test
    public void testSelectByPostId() {
        Assertions.assertNotNull(commentDao);
    }
    
}
