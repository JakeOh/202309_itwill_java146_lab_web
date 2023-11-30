package com.itwill.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.post.PostListItemDto;
import com.itwill.spring2.repository.PostDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // 스프링 컨테이너에서 관리하는 서비스 컴포넌트.
public class PostService {
    // PostDao를 주입받음.
    @Autowired private PostDao postDao;

    public List<PostListItemDto> read() {
        log.debug("read()");
        
        // postDao의 메서드를 호출해서 포스트 목록을 리턴받고, 컨트롤러에게 리턴해줌.
        List<Post> list = postDao.selectOrderByIdDesc();
        log.debug("포스트 목록 개수 = {}", list.size());
        
        return list.stream()
                .map(PostListItemDto::fromEntity) // map((x) -> PostListItemDto.fromEntity(x))
                .toList();
    }
    
}
