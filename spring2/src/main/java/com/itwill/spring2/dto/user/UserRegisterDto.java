package com.itwill.spring2.dto.user;

import com.itwill.spring2.domain.User;

import lombok.Data;

// 회원가입 정보를 저장하는 DTO
@Data
public class UserRegisterDto {
    private String userid;
    private String password;
    private String email;
    
    // DTO의 필드 값들을 사용해서 엔터티 객체를 생성하고 리턴.
    public User toEntity() {
        return User.builder()
                .userid(userid)
                .password(password)
                .email(email)
                .build();
    }

}
