package com.itwill.springboot4.web;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.springboot4.domain.Post;
import com.itwill.springboot4.dto.PostCreateRequestDto;
import com.itwill.springboot4.dto.PostSearchRequestDto;
import com.itwill.springboot4.dto.PostUpdateRequestDto;
import com.itwill.springboot4.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller @RequestMapping("/post")
public class PostController {
    
    private final PostService postService;
    
    @GetMapping("/list")
    public void list(
            @RequestParam(name = "p", defaultValue = "0") int p,
            Model model) {
        log.info("list(p={})", p);
        
        Page<Post> data = postService.getPostList(p);
        
        model.addAttribute("page", data);
        log.info(model.toString());
    }
    
    @PreAuthorize("hasRole('USER')") // @PreAuthorize("authenticated()")
    @GetMapping("/create")
    public void create() {
        log.info("create() GET");
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public String create(@ModelAttribute PostCreateRequestDto dto) {
        log.info("create(dto={})", dto);
        
        postService.create(dto);
        
        return "redirect:/post/list";
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping({"/details", "/modify"})
    public void read(@RequestParam(name = "id") Long id, Model model) {
        log.info("read(id={})", id);
        
        Post entity = postService.readById(id);
        model.addAttribute("post", entity);
    }
    
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        log.info("delete(id={})", id);
        
        postService.deleteById(id);
        
        return "redirect:/post/list";
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/update")
    public String update(@ModelAttribute PostUpdateRequestDto dto) {
        log.info("update(dto={})", dto);
        
        postService.update(dto);
        
        return "redirect:/post/list";
    }
    
    @GetMapping("/search")
    public void search(@ModelAttribute PostSearchRequestDto dto, Model model) {
        log.info("search(dto={})", dto);
        
        // Service 메서드 호출 -> 검색 결과 -> Model -> View
        Page<Post> data = postService.search(dto);
        model.addAttribute("page", data);
    }
    
}
