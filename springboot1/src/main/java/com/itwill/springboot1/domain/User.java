package com.itwill.springboot1.domain;

import java.math.BigDecimal;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // JPA의 엔터티 클래스
@Table(name = "USERS") // 데이터베이스의 테이블 이름을 설정.
// 엔터티 클래스가 상속하는 상위 클래스에는 @MappedSuperclass 애너테이션을 사용해야 함.
public class User extends BaseTimeEntity {
    
    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    //-> Oracle의 generated as identity. MySQL의 autoincrement와 비슷한 기능.
    private Long id;
    
    @NaturalId // Unique 제약 조건.
    @Basic(optional = false) // 데이터베이스 기본 타입으로 매핑. Not Null 제약 조건.
    private String username;
    
    @Enumerated(EnumType.STRING)
    //-> @Enumerated(EnumType.Ordinal) 기본값. 기본값인 경우에는 생략 가능.
    //-> Ordinal: 숫자 타입 컬럼으로 매핑.
    //-> String: 문자열 타입 컬럼으로 매핑.
    private Gender gender;
    
    @Column(length = 1000) // length: 테이블 컬럼의 문자열 길이 설정. DDL 자동 실행할 때.
    private String memo;
    
    @Column(name = "SAL", precision = 4, scale = 2)
    //-> name: (엔터티 객체의 필드 이름과 테이블 컬럼 이름이 다를 때) 테이블의 컬럼 이름을 설정.
    //-> precision, scale: DDL을 자동 실행할 때. 오라클에서는 Number(precision, scale) 매핑.
    private BigDecimal salary;
    
    //@Embedded //-> @Embeddable 애너테이션을 사용한 객체를 포함. 생략 가능.
    private Address address;

}
