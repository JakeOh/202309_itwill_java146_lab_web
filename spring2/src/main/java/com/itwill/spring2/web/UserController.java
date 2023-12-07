package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.domain.User;
import com.itwill.spring2.dto.user.UserRegisterDto;
import com.itwill.spring2.dto.user.UserSignInDto;
import com.itwill.spring2.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// 디스패쳐 서블릿에서 호출하는 컨트롤러 메서드들을 가지고 있는 클래스.
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
    
    private final UserService userService;
    
    @GetMapping("/signup")
    public void signup() {
        log.debug("GET - signup()");
    }
    
    @PostMapping("/signup")
    public String signup(@ModelAttribute UserRegisterDto dto) {
        log.debug("POST - signup(dto={})", dto);
        
        // 회원가입 서비스 수행.
        int result = userService.create(dto);
        
        return "redirect:/user/signin"; // 로그인(signin) 페이지로 이동(redirect)
    }
    
    @GetMapping("/signin")
    public void signin() {
        log.debug("GET - signin()");
    }
    
    @PostMapping("/signin")
    public String signin(@ModelAttribute UserSignInDto dto, HttpSession session) {
        log.debug("POST - signin(dto={}, session={})", dto, session);
        
        // 서비스 메서드를 호출해서 아이디와 비밀번호가 일치하는 사용자가 있는 지 확인
        User user = userService.read(dto);
        if (user != null) { // 아이디와 비밀번호 모두 일치하는 사용자가 있는 경우 -> 로그인 성공
            // 세션에 로그인 사용자 정보를 저장
            session.setAttribute("signedInUser", user.getUserid());
            
            // 타겟 페이지로 이동
            return "redirect:/";
            
        } else { // 아이디와 비밀번호가 일치하는 사용자가 없는 경우 -> 로그인 실패
            // 로그인 페이지로 이동
            return "redirect:/user/signin?result=f";
        }
    }
    
    @GetMapping("/signout")
    public String signout(HttpSession session) {
        log.debug("signout(session={})", session);
        
        // 세션에 저장된 "signedInUser" 정보를 삭제.
        session.removeAttribute("signedInUser");
        
        // 세션을 만료시킴.
        session.invalidate();
        
        // 로그아웃 이후 로그인 페이지로 이동
        return "redirect:/user/signin";
    }
    
    @GetMapping("/checkid")
    @ResponseBody
    public ResponseEntity<String> checkId(@RequestParam(name = "userid") String userid) {
        log.debug("checkId(userid={})", userid);
        
        boolean result = userService.checkUserid(userid);
        if (result) {
            return ResponseEntity.ok("Y");
        } else {
            return ResponseEntity.ok("N");
        }
    }

}
