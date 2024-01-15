package com.itwill.springboot4.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE) @Builder
@Getter @ToString(callSuper = true) @EqualsAndHashCode
@Entity @Table(name = "posts")
// @MappedSuperclass 애너테이션이 있는 엔터티를 상속함.
public class Post extends BaseTimeEntity {
    
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 테이블 생성 시 generated as identity.
    private Long id;
    
    @Basic(optional = false)
    private String title;
    
    @Basic(optional = false)
    private String content;
    
    @Basic(optional = false)
    private String author;

    // update에 필요한 메서드
    public Post update(String title, String content) {
        this.title = title;
        this.content = content;
        
        return this;
    }
    
}
