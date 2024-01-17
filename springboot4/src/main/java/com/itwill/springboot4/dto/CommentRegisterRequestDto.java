package com.itwill.springboot4.dto;

import lombok.Data;

@Data
public class CommentRegisterRequestDto {
    
    private Long postId;
    private String text;
    private String writer;
    
}
