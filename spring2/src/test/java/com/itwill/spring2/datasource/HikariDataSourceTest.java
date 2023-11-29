package com.itwill.spring2.datasource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j // Logger 객체 생성.
@ExtendWith(SpringExtension.class) // Spring JUnit 테스트를 실행하는 메인 클래스.
@ContextConfiguration(
        locations = { "file:src/main/webapp/WEB-INF/application-context.xml" }
) // 스프링 컨텍스트(환경 변수) 파일의 경로(이름).
public class HikariDataSourceTest {
    
    /*
     * 의존성 주입(DI: dependency injection), 제어의 역전(IoC: Inversion of Control):
     * 전통적인 자바 개발 방법에서는 객체를 사용하는 곳에서 객체를 생성하고, 그 기능을 이용함.
     * 스프링 프레임워크에서는 스프링 컨터이너가 필요한 객체를 미리 메모리에 생성해 두고,
     * 객체를 필요로 하는 곳에서는 변수 선언과 애너테이션만 사용하면
     * 스프링 컨테이너가 생성/관리하고 있는 빈(bean)을 필요한 곳에 주입해 줌.
     * application-context.xml 파일에 선언된 bean들을 스프링 컨터이너가 생성/관리함.
     */
    
    @Autowired // 스프링 컨테이너가 생성/관리하는 빈(bean)을 변수에 자동 할당(주입).
    private HikariConfig config;
    
    @Autowired
    private HikariDataSource ds;
    
    @Test
    public void test() {
        Assertions.assertNotNull(config);
        log.debug("config={}", config);
        
        Assertions.assertNotNull(ds);
        log.debug("ds={}", ds);
    }

}
