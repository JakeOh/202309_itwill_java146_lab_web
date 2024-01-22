package com.itwill.springboot4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MemberRepositoryTest {
    
    @Autowired private MemberRepository memberDao;
    @Autowired private PasswordEncoder passwordEncoder;

    @Test
    public void test() {
        Assertions.assertNotNull(memberDao);
        log.info("memberDao={}", memberDao);
        
        Assertions.assertNotNull(passwordEncoder);
        log.info("passwordEncoder={}", passwordEncoder);
    }
    
}
