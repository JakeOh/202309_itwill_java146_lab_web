package com.itwill.spring2.domain;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

// DB 테이블 POSTS 테이블 - 필드 이름은 컬럼 이름과 같게!
@Data
@Builder
public class Post {
    
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime created_time;
    private LocalDateTime modified_time;

}
