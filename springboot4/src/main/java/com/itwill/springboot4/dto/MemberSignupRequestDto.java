package com.itwill.springboot4.dto;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.itwill.springboot4.domain.Member;

import lombok.Data;

@Data
public class MemberSignupRequestDto {
    
    private String username;
    private String password;
    private String email;
    
    public Member toEntity(PasswordEncoder encoder) {
        return Member.builder()
                .username(username)
                .password(encoder.encode(password))
                .email(email)
                .build();
    }
    
}
