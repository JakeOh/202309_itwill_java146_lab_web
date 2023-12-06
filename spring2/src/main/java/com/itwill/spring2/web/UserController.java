package com.itwill.spring2.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.service.UserService;

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
