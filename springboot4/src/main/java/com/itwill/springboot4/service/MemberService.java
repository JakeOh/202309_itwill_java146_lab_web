package com.itwill.springboot4.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.Member;
import com.itwill.springboot4.domain.MemberRepository;
import com.itwill.springboot4.dto.MemberSecurityDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberService implements UserDetailsService {
    
    private final MemberRepository memberDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // MemberRepository의 메서드를 호출해서 username이 일치하는 사용자 정보가 있는 지를
        // 리턴. 만약 사용자 정보가 없으면 exception을 던짐.
        log.info("loadUserByUsername(username={})", username);
        
        Optional<Member> opt = memberDao.findByUsername(username);
        if (opt.isPresent()) {
            return MemberSecurityDto.fromEntity(opt.get());
        } else {
            throw new UsernameNotFoundException(username + " 찾을 수 없음!");
        }
        
    }

}
