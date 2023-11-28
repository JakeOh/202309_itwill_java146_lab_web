package com.itwill.spring2.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.itwill.spring2.jdbc.JdbcTest;
import com.zaxxer.hikari.HikariConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Logger 객체 생성.
@ExtendWith(SpringExtension.class) // Spring JUnit 테스트를 실행하는 메인 클래스.
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
) // 스프링 컨텍스트(환경 변수) 파일의 경로(이름).
public class HikariDataSourceTest {
    
    @Autowired
    private HikariConfig config;
    
    @Test
    public void test() {
        Assertions.assertNotNull(config);
        log.debug("config={}", config);
    }

}
