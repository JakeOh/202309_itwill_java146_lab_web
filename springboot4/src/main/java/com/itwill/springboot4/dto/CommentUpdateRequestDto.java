package com.itwill.springboot4.dto;

import lombok.Data;

@Data
public class CommentUpdateRequestDto {
    
    private Long id;
    private String text;

}
