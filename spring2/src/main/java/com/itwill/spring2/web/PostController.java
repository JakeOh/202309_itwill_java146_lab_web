package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.domain.Post;
import com.itwill.spring2.dto.post.PostCreateDto;
import com.itwill.spring2.dto.post.PostListItemDto;
import com.itwill.spring2.dto.post.PostSearchDto;
import com.itwill.spring2.dto.post.PostUpdateDto;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자.
@Controller
@RequestMapping("/post")
//-> PostController의 컨트롤러 메서드의 매핑 URL(주소)는 "/post"로 시작.
public class PostController {
    // PostService 객체를 주입받음.
    // (1) 애너테이션을 사용한 의존성 주입
    // @Autowired private PostService postService;
    
    // (2) 생성자에 의한 의존성 주입
    private final PostService postService;
//    public PostController(PostService s) {
//        this.postService = s;
//    }
    
    @GetMapping("/list") //-> GET 방식의 "/post/list" 요청 주소를 처리하는 메서드
    public void list(Model model) {
        log.debug("list()");
        
        // postService의 메서드를 호출해서 포스트 목록을 만들고, 뷰에 전달.
        List<PostListItemDto> list = postService.read();
        model.addAttribute("posts", list);
        
        // 리턴 값이 없으면 요청 경로로 뷰(JSP)를 찾음.
        // -> /WEB-INF/views/post/list.jsp
    }
    
    @GetMapping("/create")
    public void create() {
        log.debug("GET - create()");
    }
    
    @PostMapping("/create")
    public String create(PostCreateDto dto) {
        log.debug("POST - create(dto={})", dto);
        
        // 서비스 계층의 메서드를 호출해서 새 포스트 작성 서비스를 수행.
        postService.create(dto);
        
        return "redirect:/post/list"; // 포스트 목록 페이지로 이동(redirect)
    }
    
    @GetMapping({ "/details", "/modify" })
    //-> /post/details, /post/modify 2개의 요청을 처리하는 메서드
    public void details(@RequestParam(name = "id") long id, Model model) {
        log.debug("details(id={})", id);
        
        // 서비스 계층의 메서드를 호출해서 뷰에 전달할 포스트 상세보기 내용을 읽음.
        Post post = postService.read(id);
        
        // 뷰에 데이터 전달하기 위해서모델에 데이터를 속성으로 추가
        model.addAttribute("post", post);
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") long id) {
        log.debug("delete(id={})", id);
        
        // 서비스 계층의 메서드를 호출해서 해당 아이디의 포스트를 삭제하는 서비스를 수행.
        postService.delete(id);
        
        // 포스트 삭제후 포스트 목록 페이지로 이동(redirect)
        return "redirect:/post/list";
    }
    
    @PostMapping("/update")
    public String update(PostUpdateDto dto) {
        log.info("update(dto={})", dto);
        
        // 서비스 계층의 메서드를 호출해서 포스트 업데이트 서비스를 수행.
        postService.update(dto);
        
        // 포스트 업데이트 수 포스트 목록 페이지로 이동(redirect)
        return "redirect:/post/list";
    }
    
    @GetMapping("/search")
    public String search(PostSearchDto dto, Model model) {
        log.debug("search(dto={})", dto);
        
        // 서비스 계층의 메서드를 호출해서 검색 서비스를 수행.
        List<PostListItemDto> list = postService.search(dto);
        
        // 검색 결과를 뷰에 전달하기 위해서 모델 속성(attribute)에 추가.
        model.addAttribute("posts", list);
        
        return "post/list"; //-> 뷰의 경로(/WEB-INF/views/post/list.jsp)
    }
    
}
