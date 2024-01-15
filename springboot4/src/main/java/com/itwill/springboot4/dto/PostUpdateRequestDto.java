package com.itwill.springboot4.dto;

import com.itwill.springboot4.domain.Post;

import lombok.Data;

@Data
public class PostUpdateRequestDto {

    private Long id;
    private String title;
    private String content;
    
    public Post toEntity() {
        return Post.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();
    }
    
}
