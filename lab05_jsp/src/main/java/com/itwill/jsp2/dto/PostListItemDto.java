package com.itwill.jsp2.dto;

import java.time.LocalDateTime;

import com.itwill.jsp2.domain.Post;

// 포스트 목록 페이지에서 테이블의 행에 사용되는 데이터 클래스.
public class PostListItemDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedTime;

    public PostListItemDto() {}

    public PostListItemDto(Long id, String title, String author, LocalDateTime modifiedTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.modifiedTime = modifiedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "PostListItemDto [id=" + id + ", title=" + title + ", author=" + author + ", modifiedTime="
                + modifiedTime + "]";
    }
    
    // Post 타입 객체를 PostListItemDto 객체로 변환해서 리턴하는 메서드
    public static PostListItemDto fromPost(Post post) {
        return new PostListItemDto(post.getId(), post.getTitle(), post.getAuthor(), 
                post.getModifiedTime());
    }
    
}
