package com.itwill.spring1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

// POJO(Plain Old Java Object): 평범한 자바 객체.
// 특정 클래스를 상속(extends)하거나, 특정 인터페이스를 구현(implements)할 필요가 없는
// (상위 타입의 특정 메서드를 반드시 재정의할 필요가 없는) 평범한 자바 객체.
// 스프링 프레임워크는 POJO로 작성된 클래스를 컨트롤러로 사용할 수 있음.
// (비교) Servlet을 상속받는 클래스에서는 doGet(req, resp) 또는 doPost(req, resp)를 반드시 override.

@Slf4j //-> private static final Logger log 변수를 선언하고 초기화를 해줌.
@Controller //-> 디스패쳐 서블릿에게 컨트롤러 컴포넌트임을 알려줌.
//-> 디스패쳐 서블릿이 객체를 생성, 관리 - 필요할 때 메서드를 호출.
public class ExampleController {

    @GetMapping("/") //-> 컨텍스트 루트로 GET 방식의 요청이 왔을 때 호출되는 메서드
    public String home() {
        log.debug("home()");
        
        return "home";
    }
    
}
