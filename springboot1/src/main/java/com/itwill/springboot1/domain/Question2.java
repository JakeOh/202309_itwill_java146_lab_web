package com.itwill.springboot1.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "QUESTIONS2")
public class Question2 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String subject;
    
    private String content;
    
    @OneToMany
    // answers2 엔터티에서는 @ManyToOne을 사용하지 않고,
    // question2 엔터티에서만 @OneToMany를 사용한 단방향 연결인 경우
    // questions2_answers 관계 테이블을 자동으로 생성.
    private List<Answer2> answers;

}
