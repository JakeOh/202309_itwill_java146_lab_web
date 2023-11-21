package com.itwill.jsp2.dto;

import com.itwill.jsp2.domain.Post;

// DTO(Data Transfer Object): Controller <---> Service
public class PostUpdateDto {
    private Long id;
    private String title;
    private String content;
    
    public PostUpdateDto() {}

    public PostUpdateDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "PostUpdateDto [id=" + id + ", title=" + title + ", content=" + content + "]";
    }
    
    // PostUpdateDto 타입 객체를 Post 타입으로 변환해서 리턴.
    //-> 서비스에서 영속성 계층의 메서드를 호출할 때 사용 예정.
    public Post toPost() {
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setContent(content);
        
        return post;
    }
    
}
