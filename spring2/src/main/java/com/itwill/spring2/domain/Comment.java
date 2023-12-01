package com.itwill.spring2.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

// 데이터베이스 COMMENTS 테이블의 모델(엔터티).
@Data
@Builder
public class Comment {
    
    private Long id; // PK
    private Long postid; // FK - POSTS 테이블의 ID 컬럼 참조
    private String writer; // 댓글 작성자 아이디
    private String ctext; // 댓글 내용
    private LocalDateTime created_time; // 댓글 최초 작성 시간
    private LocalDateTime modified_time; // 댓글 최종 수정 시간

}
