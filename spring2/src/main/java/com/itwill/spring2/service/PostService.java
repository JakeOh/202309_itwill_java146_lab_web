package com.itwill.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링 컨테이너에서 관리하는 서비스 컴포넌트.
public class PostService {
    // TODO: PostDao를 주입받음.

    public List<Post> read() {
        // TODO: postDao의 메서드를 호출해서 포스트 목록을 리턴받고, 컨트롤러에게 리턴해줌.
        
        return null;
    }
    
}
