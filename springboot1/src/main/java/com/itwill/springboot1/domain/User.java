package com.itwill.springboot1.domain;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // JPA의 엔터티 클래스
@Table(name = "USERS") // 데이터베이스의 테이블 이름을 설정.
public class User {
    
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // MySQL의 autoincrement와 비슷한 기능.
    private Long id;
    
    @NaturalId // Unique 제약 조건.
    @Basic(optional = false) // 데이터베이스 기본 타입으로 매핑. Not Null 제약 조건.
    private String username;

}
