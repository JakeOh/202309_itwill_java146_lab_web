package com.itwill.springboot4.service;

import org.springframework.stereotype.Service;

import com.itwill.springboot4.domain.CommentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentService {
    
    private final CommentRepository commentDao;

}
