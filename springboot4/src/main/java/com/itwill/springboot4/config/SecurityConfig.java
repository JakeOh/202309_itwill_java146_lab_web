package com.itwill.springboot4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//-> 스프링 컨테이너에 객체(bean)를 생성, 관리 - 필요한 곳에 의존성 주입.
public class SecurityConfig {
    
    // Spring Security 5 버전부터 비밀번호는 반드시 암호화를 해야 함.
    // 비밀번호를 암호화하지 않으면 HTTP 403(access denied, 접근 거부) 또는
    // HTTP 500 (내부 서버 오류, internal server error) 에러가 발생함.
    // 비밀번호 암호화를 할 수 있는 객체를 스프링 컨테이너가 bean으로 관리해야 함.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
