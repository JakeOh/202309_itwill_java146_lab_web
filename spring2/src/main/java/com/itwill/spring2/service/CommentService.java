package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.comment.CommentRegisterDto;
import com.itwill.spring2.repository.CommentDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    
    private final CommentDao commentDao; // 생성자에 의한 의존성 주입
    
    public int create(CommentRegisterDto dto) {
        log.debug("create(dto={})", dto);
        
        // 리포지토리 계층의 메서드를 호출해서 COMMENTS 테이블에 데이터를 삽입(insert).
        int result = commentDao.insert(dto.toEntity());
        log.debug("댓글 등록 결과 = {}", result);
        
        return result;
    }

}