package com.itwill.springboot4.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.springboot4.domain.Comment;
import com.itwill.springboot4.dto.CommentRegisterRequestDto;
import com.itwill.springboot4.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentRestController {
    
    private final CommentService commentSvc;
    
    @PostMapping
    public ResponseEntity<Comment> registerComment(@RequestBody CommentRegisterRequestDto dto) {
        log.info("registerComment(dto={})", dto);
        
        // 서비스 메서드를 호출해서 댓글을 등록하고, 등록된 댓글을 응답으로 보냄.
        Comment entity = commentSvc.register(dto);
        log.info("id={}, created={}", entity.getId(), entity.getCreatedTime());
        
        return ResponseEntity.ok(entity);
    }

}
