package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.dto.comment.CommentRegisterDto;
import com.itwill.spring2.service.CommentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentRestController {
    
    private final CommentService commentService; // 생성자에 의한 의존성 주입
    
    @PostMapping
    public ResponseEntity<Integer> registerComment(@RequestBody CommentRegisterDto dto) {
        // 컨트롤러 메서드의 파라미터 선언에서 사용하는 애너테이션:
        // @RequestParam: 질의 문자열(query string)에 포함된 요청 파라미터를 읽을 때.
        // @ModelAttribute: POST 방식의 양식 데이터를 읽을 때.
        // @RequestBody: Ajax 요청의 요청 패킷 바디에 포함된 데이터를 읽어서 자바 객체로 변환.
        // -> jackson-databind 라이브러리: JSON 문자열을 자바 객체로 변환.
        // -> jackson-databind 동작방식: 클래스의 기본 생성자 호출 -> setter 메서드를 호출
        log.debug("registerComment(dto={})", dto);
        
        // 서비스 계층의 메서드를 호출해서 댓글 등록 서비스를 수행.
        int result = commentService.create(dto);
        
        // ResponseEntity<T>: 서버가 클라이언트로 보내는 데이터와 응답코드를 설정할 수 있는 객체.
        return ResponseEntity.ok(result); //-> 응답코드(200:success)와 데이터 result를 클라이언트로 전송.
    }

}
