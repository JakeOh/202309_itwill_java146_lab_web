package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/post")
//-> PostController의 컨트롤러 메서드의 매핑 URL(주소)는 "/post"로 시작.
public class PostController {
    
    @GetMapping("/list") //-> GET 방식의 "/post/list" 요청 주소를 처리하는 메서드
    public void list() {
        log.debug("list()");
        // 리턴 값이 없으면 요청 경로로 JSP를 찾음.
        // -> /WEB-INF/views/post/list.jsp
    }

}
