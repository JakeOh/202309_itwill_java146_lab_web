package com.itwill.jsp2.dto;

import com.itwill.jsp2.domain.Post;

// DTO(Data Transfer Object): 메서드의 아규먼트로 전달되거나 리턴 타입으로 사용되는 객체.
// 웹 계층 간(Controller <--> Service)에 데이터를 주고 받을 때 사용되는 객체.
// 새 포스트 작성에서 사용될 DTO.
public class PostCreateDto {
    private String title;
    private String content;
    private String author;
    
    public PostCreateDto() {}

    public PostCreateDto(String title, String content, String author) {
        super();
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "PostCreateDto [title=" + title + ", content=" + content + ", author=" + author + "]";
    }
    
    // PostCreateDto 타입의 객체를 Post 타입 객체로 변환해서 리턴하는 메서드
    //-> Service 계층에서 Repository 계층의 메서드를 호출할 때 사용. 
    public Post toPost() {
        return new Post(title, content, author);
    }
}
