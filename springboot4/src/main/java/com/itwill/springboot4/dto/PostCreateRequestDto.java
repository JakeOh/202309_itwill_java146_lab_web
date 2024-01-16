package com.itwill.springboot4.dto;

import com.itwill.springboot4.domain.Post;

import lombok.Data;

@Data
//-> 기본 생성자, getters & setters
public class PostCreateRequestDto {

    private String title;
    private String content;
    private String author;
    
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    
}
