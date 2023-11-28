package com.itwill.spring1.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring1.dto.ExampleDto;

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
    public String home(Model model) {
        log.debug("home()");
        
        LocalDateTime now = LocalDateTime.now(); // 현재 시간
        model.addAttribute("now", now);
        
        return "home";
        // 컨트롤러 메서드가 문자열을 리턴하면 디스패쳐 서블릿이 뷰의 이름을 찾는 데 사용.
        // /WEB-INF/views/home.jsp
    }
    
    @GetMapping("/ex1")
    public void example1() {
        log.debug("example1()");
        // 컨트롤러 메서드가 void인 경우(리턴값이 없는 경우), 요청 주소가 뷰의 경로(이름)가 됨.
    }
    
    @GetMapping("/ex2")
    public void example2(@RequestParam(name = "username") String username, 
            @RequestParam(name = "age", defaultValue = "0") int age,
            Model model) {
        // @RequestParam: 디스패쳐 서블릿에서 요청 파라미터를 분석(request.getParameter(name))해서 
        // 컨트롤러 메서드를 호출할 때 아규먼트를 전달할 수 있음.
        // name 속성: 요청 파라미터 이름.
        // defaultValue 속성: 요청 파라미터 값이 없을 때(빈 문자열일 때) 사용할 기본값.
        
        ExampleDto dto = ExampleDto.builder().age(age).username(username).build();
        model.addAttribute("dto", dto); //-> 뷰에 전달되는 데이터.
        
        log.debug("example2(username={}, age={})", username, age);
    }
    
    @PostMapping("/ex3")
    public String example3(@ModelAttribute(name = "dto") ExampleDto dto) {
        log.debug("example3(dto={})", dto);
        // 디스패쳐 서블릿이 컨트롤러 메서드를 호출하기 위해서
        // (1) request.getParameter("username"), request.getParameter("age")
        // (2) ExampleDto의 생성자 호출 -> 객체 생성.
        // (3) DTO 객체를 example3() 메서드의 아규먼트로 전달.
        
        // @ModelAttribute(name = "dto") ExampleDto dto
        //-> model.addAttribute("dto", dto); 코드 작성과 같은 효과.
        //-> 컨트롤러 메서드의 아규먼트를 뷰에 전달하는 모델 속성(attribute)로 설정함.
        
        return "ex2"; // 뷰(jsp 파일) 이름을 리턴.
    }
    
    @GetMapping("/test")
    public void test() {
        log.debug("test()");
    }
    
    @GetMapping("/forward")
    public String forward() {
        log.debug("forward()");
        
        return "forward:/test"; // 요청 주소 "/test"로 전달(forward)
        // 포워드 방식의 페이지 이동 - 요청 주소가 최초의 요청 주소 그대로 유지.
    }
    
    @GetMapping("/redirect")
    public String redirect() {
        log.debug("redirect()");
        
        return "redirect:/test"; // 요청 주소 "/redirect"로 이동(redirect)
        // 리다이렉트 방식의 페이지 이동 - 응답 완료 & 새로운 요청 - 요청 주소가 바뀜.
    }
    
    @GetMapping("/rest1")
    @ResponseBody
    //-> 컨트롤러 메서드가 리턴하는 값이 뷰를 찾기 위한 문자열이 아니라,
    // 응답 패킷의 바디로 사용됨 -> 클라이언트로 직접 전달되는 데이터.
    public String rest1() {
        log.debug("rest1()");
        
        return "Hello";
    }
    
    @GetMapping("/rest2")
    @ResponseBody
    public ExampleDto rest2() {
        log.debug("rest2()");
        
        ExampleDto dto = ExampleDto.builder().age(16).username("홍길동").build();
        
        return dto;
        // REST 컨트롤러가 리턴한 자바 객체를 jackson-databind 라이브러리에서
        // JSON(JavaScript Object Notation) 문자열로 변환 후 클라이언트로 응답.
    }
    
}
