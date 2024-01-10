package com.itwill.springboot2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        log.info("home()");
        
        return "index"; // 뷰의 이름: templates/index.html
    }

}
