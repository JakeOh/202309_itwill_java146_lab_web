package com.itwill.springboot4.domain;

import java.util.List;
import java.util.Optional;

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

//    @Test
    public void test() {
        Assertions.assertNotNull(memberDao);
        log.info("memberDao={}", memberDao);
        
        Assertions.assertNotNull(passwordEncoder);
        log.info("passwordEncoder={}", passwordEncoder);
        
        Member m = Member.builder()
                .username("user2")
                .password(passwordEncoder.encode("2222"))
                .email("user2@itwill.com")
                .build();
        m.addRole(MemberRole.ADMIN);
        
        log.info("save 전: {}", m);
        
        memberDao.save(m); // insert 쿼리 실행.
        log.info("save 후: {}", m);
    }
    
//    @Test @Transactional
    public void testFindAll() {
        List<Member> list = memberDao.findAll();
        list.forEach((x) -> log.info("{}, {}", x, x.getRoles()));
    }
    
    @Test
    public void testFindByUsername() {
        Optional<Member> m = memberDao.findByUsername("admin");
        log.info("{}, {}", m, m.get().getRoles());
    }
    
}
