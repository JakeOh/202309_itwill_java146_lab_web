package com.itwill.spring1.web;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.spring1.dto.ExampleDto;

import lombok.extern.slf4j.Slf4j;

// REST 서비스를 하는 컨트롤러 메서드를 작성하는 방법:
// (1) @Controller 클래스에서 @ResponseBody 애너테이션을 사용한 메서드를 만듦.
// (2) @RestController 클래스의 모든 컨트롤러 메서드는 REST 서비스로 구현됨.
// -> 리턴값은 클라이언트로 직접 응답되는 데이터.

@Slf4j
@RestController
public class ExampleRestController {

    @GetMapping("/rest3")
    public String rest3() {
        log.debug("rest3()");
        
        return "안녕하세요, REST!";
    }
    
    @GetMapping("/rest4")
    public ArrayList<ExampleDto> rest4() {
        log.debug("rest4()");
        
        ArrayList<ExampleDto> list = new ArrayList<>();
        list.add(new ExampleDto("홍길동", 16));
        list.add(new ExampleDto("Scott", 10));
        
        return list;
    }
    
}
