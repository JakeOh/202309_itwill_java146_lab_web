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
    
    public static PostListItemDto fromEntity(Post post) {
        return PostListItemDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor())
                .modifiedTime(post.getModified_time())
                .build();
    }

}
