package com.itwill.spring2.dto.comment;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRegisterDto {
    private Long postId;
    private String ctext;
    private String writer;

}
