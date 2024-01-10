package com.itwill.springboot1.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "answers")
public class Answer {
    
    @Id
    @GeneratedValue(generator = "answer_seq", strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne // 다대일 관계
    // 테이블의 컬럼 이름: question_[Question 엔터티의 ID 필드]
    private Question question;
    
    @Basic(optional = false)
    private String answer;

}
