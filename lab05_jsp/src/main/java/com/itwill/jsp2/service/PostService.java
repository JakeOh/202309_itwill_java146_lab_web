package com.itwill.jsp2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.Post;
import com.itwill.jsp2.dto.PostCreateDto;
import com.itwill.jsp2.dto.PostListItemDto;
import com.itwill.jsp2.dto.PostUpdateDto;
import com.itwill.jsp2.repository.PostDao;
import com.itwill.jsp2.repository.UserDao;

// Model 2 MVC 아키텍쳐에서 서비스(비즈니스) 계층을 담당하는 클래스.
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    
    // singleton 적용:
    private static PostService instance = null;
    
    private final PostDao postDao;
    private final UserDao userDao;
    
    // final로 선언된 필드는 반드시 명시적으로 초기화를 수행해야 함!
    // (1) 필드를 선언하는 위치에서 초기화를 하거나,
    // (2) 생성자에서 초기화.
    
    private PostService() {
        postDao = PostDao.getInstance();
        userDao = UserDao.getInstance();
    }
    
    public static PostService getInstance() {
        if (instance == null) {
            instance = new PostService();
        }
        
        return instance;
    }
    
    public List<PostListItemDto> read() {
        log.info("read()");
        
        // DAO의 메서드를 호출해서 DB POSTS 테이블에서 (아이디 내림차순) 전체 검색.
        List<Post> list =  postDao.select();
        
        // List<Post>를 List<PostListItemDto>로 변환해서 컨트롤러에게 리턴.
        List<PostListItemDto> result = list.stream()
                .map(PostListItemDto::fromPost) // (x) -> PostListItemDto.fromPost(x)
                .toList();
        
        return result;
    }
    
    public void create(PostCreateDto dto) {
        log.debug("create(dto={})", dto);
        
        // PostCreateDto를 Post 타입으로 변환해서, PostDao의 메서드(insert)를 호출할 때 전달.
        int result = postDao.insert(dto.toPost());
        log.debug("insert result = {}", result);
        
        if (result == 1) { // 새 포스트 작성을 성공하면, 
            // 포스트 작성자에게 10 포인트를 지급.
            userDao.updatePoints(10, dto.getAuthor());
        }
    }
    
    public Post read(Long id) {
        log.debug("read(id={})", id);
        
        Post post = postDao.select(id);
        log.debug("select result = {}", post);
        
        return post;
    }
    
    public int delete(Long id) {
        log.debug("delete(id={})", id);
        
        int result = postDao.delete(id);
        log.debug("delete result = {}", result);
        
        return result;
    }
    
    public int update(PostUpdateDto dto) {
        log.debug("update(dto={})", dto);
        
        int result = postDao.update(dto.toPost());
        log.debug("update result = {}", result);
        
        return result;
    }

    public List<PostListItemDto> search(String category, String keyword) {
        log.debug("search(category={}, keyword={})", category, keyword);
        
        List<Post> list = postDao.search(category, keyword);
        log.debug("검색 결과 개수 = {}", list.size());
        
        List<PostListItemDto> result = list.stream()
                .map(PostListItemDto::fromPost)
                .toList();
        
        return result;
    }
    
}
