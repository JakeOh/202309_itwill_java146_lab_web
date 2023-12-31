package com.itwill.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.post.PostCreateDto;
import com.itwill.spring2.dto.post.PostListItemDto;
import com.itwill.spring2.dto.post.PostSearchDto;
import com.itwill.spring2.dto.post.PostUpdateDto;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service // 스프링 컨테이너에서 관리하는 서비스 컴포넌트.
public class PostService {
    // PostDao를 주입받음.
    // @Autowired private PostDao postDao;
    private final PostDao postDao;
//    public PostService(PostDao postDao) {
//        this.postDao = postDao;
//    }

    public List<PostListItemDto> read() {
        log.debug("read()");
        
        // postDao의 메서드를 호출해서 포스트 목록을 리턴받고, 컨트롤러에게 리턴해줌.
        List<Post> list = postDao.selectOrderByIdDesc();
        log.debug("포스트 목록 개수 = {}", list.size());
        
        return list.stream()
                .map(PostListItemDto::fromEntity) // map((x) -> PostListItemDto.fromEntity(x))
                .toList();
    }
    
    public int create(PostCreateDto dto) {
        log.debug("create(dto={})", dto);
        
        // 리포지토리(DAO) 계층의 메서드를 호출해서 테이블에 데이터를 삽입(insert)
        int result = postDao.insert(dto.toEntity());
        log.debug("create result = {}", result);
        
        return result;
    }
    
    public Post read(long id) {
        log.debug("read(id={})", id);
        
        // 리포지토리 계층의 메서드를 호출해서 DB 테이블에서 해당 아이디의 포스트 상세내용을 검색.
        Post post = postDao.selectById(id);
        log.debug("{}", post);
        
        return post;
    }
    
    public int delete(long id) {
        log.debug("delete(id={})", id);
        
        // 리포지토리 계층의 메서드를 호출해서 delete SQL을 실행.
        int result = postDao.delete(id);
        
        return result;
    }
    
    public int update(PostUpdateDto dto) {
        log.debug("update(dto={})", dto);
        
        // 리포지토리 계층의 메서드를 호출해서 update SQL을 실행.
        int result = postDao.update(dto.toEntity());
        
        return result;
    }
    
    public List<PostListItemDto> search(PostSearchDto dto) {
        log.debug("search(dto={})", dto);
        
        List<Post> list = postDao.search(dto);
        
        return list.stream()
                .map(PostListItemDto::fromEntity)
                .toList();
    }
    
}
