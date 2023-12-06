package com.itwill.spring2.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 데이터베이스 USERS 테이블 모델(엔터티).
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id; // PK - 오라클 시퀀스(sequence)
    private String userid; // 로그인 아이디(unique, not null)
    private String password; // 비밀번호(not null)
    private String email; // 이메일(not null)
    private Long points;

}
