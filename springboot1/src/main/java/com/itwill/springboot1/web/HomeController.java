package com.itwill.springboot1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping("/") // context root로 들어오는 GET 방식의 요청을 처리하는 메서드
    public String home() {
        log.info("home()");
        
        return "home"; //-> 뷰의 이름: home.html
    }

}
