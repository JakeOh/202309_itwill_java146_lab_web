package com.itwill.spring2.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring2.dto.comment.CommentListItemDto;
import com.itwill.spring2.dto.comment.CommentRegisterDto;
import com.itwill.spring2.dto.comment.CommentUpdateDto;
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
        // -> jackson-databind 라이브러리: JSON 문자열을 자바 객체로 변환(역직렬화, de-serialization).
        // -> jackson-databind 동작방식: 클래스의 기본 생성자 호출 -> setter 메서드를 호출
        log.debug("registerComment(dto={})", dto);
        
        // 서비스 계층의 메서드를 호출해서 댓글 등록 서비스를 수행.
        int result = commentService.create(dto);
        
        // ResponseEntity<T>: 서버가 클라이언트로 보내는 데이터와 응답코드를 설정할 수 있는 객체.
        return ResponseEntity.ok(result); //-> 응답코드(200:success)와 데이터 result를 클라이언트로 전송.
    }
    
    @GetMapping("/all/{postId}")
    public ResponseEntity<List<CommentListItemDto>> getAllComments(@PathVariable long postId) {
        // @PathVariable: 요청 주소의 일부가 변수처럼 변할 수 있는 값일 때,
        // 요청 주소를 분석해서 컨트롤러 메서드의 파라미터로 전달.
        log.debug("getAllComments(postId={})", postId);
        
        // 서비스 계층의 메서드를 호출해서 댓글 전체 목록을 가져옴.
        List<CommentListItemDto> list = commentService.read(postId);
        
        return ResponseEntity.ok(list);
        //-> 컨트롤러 메서드에서 ResponseEntity<Object>을 리턴하면
        // 자바 객체를 JSON 문자열로 변환해서 클라이언트에게 전송.
        // jackson-databind 라이브러리가 자바 객체를 JSON 문자열로 변환을 담당.
        // 직렬화(serialization): 자바 객체 -> JSON
        // jackson-databind: 직렬화(객체 -> 문자열) & 역직렬화(문자열 -> 객체) 라이브러리.
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteComment(@PathVariable long id) {
        log.debug("deleteComment(id={})", id);
        
        // 서비스 계층의 메서드를 호출해서 댓글 삭제 서비스를 수행.
        int result = commentService.delete(id);
        
        // 결과를 리턴(클라이언트로 응답을 보냄)
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CommentListItemDto> getCommentById(@PathVariable long id) {
        log.debug("getCommentById(id={})", id);
        
        // 서비스 계층의 메서드를 호출해서 응답을 보낼 DTO 객체를 읽어옴.
        CommentListItemDto dto = commentService.readById(id);
        
        // Ajax 요청에 대한 응답을 리턴.
        return ResponseEntity.ok(dto);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Integer> updateComment(@PathVariable long id, 
            @RequestBody CommentUpdateDto dto) {
        log.debug("updateComment(id={}, dto={})", id, dto);
        
        // DTO의 id(댓글 아이디)를 경로 변수(path variable) 값으로 설정.
        dto.setId(id);
        
        // 서비스 계층의 메서드를 호출해서 댓글 업데이트 서비스 수행.
        int result = commentService.update(dto);
        
        // Ajax 요청에 대한 응답을 리턴.
        return ResponseEntity.ok(result);
    }

}
