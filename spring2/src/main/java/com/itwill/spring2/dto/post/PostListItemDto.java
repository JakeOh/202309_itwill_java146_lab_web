package com.itwill.spring2.dto.post;

import java.time.LocalDateTime;

import com.itwill.spring2.domain.Post;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostListItemDto {
    
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedTime;
    
    // Post 모델(엔터티) 객체를 PostListItemDto 타입 객체로 변환해서 리턴.
    public static PostListItemDto fromEntity(Post post) {
        return PostListItemDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .modifiedTime(post.getModified_time())
                .build();
    }

}
