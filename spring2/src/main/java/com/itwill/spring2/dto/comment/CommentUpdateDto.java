package com.itwill.spring2.dto.comment;

import com.itwill.spring2.domain.Comment;

import lombok.Data;

@Data
public class CommentUpdateDto {
    private Long id;
    private String ctext;

    public Comment toEntity() {
        return Comment.builder().id(id).ctext(ctext).build();
    }
}
