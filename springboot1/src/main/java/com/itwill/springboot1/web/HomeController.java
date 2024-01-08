package com.itwill.springboot1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.springboot1.dto.Author;
import com.itwill.springboot1.dto.Book;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
    @GetMapping("/") // context root로 들어오는 GET 방식의 요청을 처리하는 메서드
    public String home(Model model) {
        log.info("home()");
        
        LocalDateTime now = LocalDateTime.now(); // 현재 시간
        model.addAttribute("currentTime", now);
        
        Author author = Author.builder().firstName("약용").lastName("정").build();
        Book book = Book.builder().id(100).title("목민심서").author(author).build();
        model.addAttribute("book", book);
        
        return "home"; //-> 뷰의 이름: home.html
    }

}
