package com.itwill.spring2.dto.post;

import com.itwill.spring2.domain.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostCreateDto {
    
    private String title;
    private String content;
    private String author;

    // PostCreateDTO 객체를 Post 모델(엔터티) 객체로 변환해서 리턴하는 메서드.
    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
    
}
