package com.itwill.springboot1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    
    // 질의 문자열의 요청 파라미터를 처리하는 컨트롤러 메서드:
    @GetMapping("/book")
    public void bookDetails(@RequestParam(name = "id") int id, Model model) {
        // 로그 레벨(log level): trace < debug < info < warning < error < fatal
        // 스프링 부트에서 기본 로그 출력 레벨은 info 이상.
        log.info("bookDetails(id={})", id);
        
        Book book = Book.builder().id(id).title("책_" + id).build();
        model.addAttribute("book", book);
        
        // return 값이 없는 경우 뷰의 이름은 요청 주소와 같음(book.html).
    }
    
    // 경로 변수(path variable)을 처리하는 컨트롤러 메서드:
    @GetMapping("/book/{id}")
    public String bookDetails2(@PathVariable(name = "id") int id, Model model) {
        log.info("bookDetails2(id={})", id);
        
        Book book = Book.builder().id(id).title("BOOK_" + id).build();
        model.addAttribute("book", book);
        
        return "book";
    }

}
