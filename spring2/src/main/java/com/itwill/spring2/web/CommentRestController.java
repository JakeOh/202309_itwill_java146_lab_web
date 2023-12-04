package com.itwill.spring2.web;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.dto.comment.CommentRegisterDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/comment")
public class CommentRestController {
    
    @PostMapping
    public String registerComment(CommentRegisterDto dto) {
        log.debug("registerComment(dto={})", dto);
        
        return "success";
    }

}
