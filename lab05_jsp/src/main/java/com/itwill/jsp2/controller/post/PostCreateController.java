package com.itwill.jsp2.controller.post;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.dto.PostCreateDto;
import com.itwill.jsp2.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostCreateController
 */
@WebServlet(name = "postCreateController", urlPatterns = { "/post/create" })
public class PostCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostCreateController.class);
	
	private final PostService postService = PostService.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doGet()");
		
		request.getRequestDispatcher("/WEB-INF/post/create.jsp")
		    .forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    log.debug("doPost()");
	    
	    // 요청 파라미터에서 title, content, author를 찾음.
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String author = request.getParameter("author");
	    log.debug("--- req params: title={}, content={}, author={}", 
	            title, content, author);
	    
	    // PostCreateDto 타입 객체 생성.
	    PostCreateDto dto = new PostCreateDto(title, content, author);
	    
	    // 서비스 계층의 메서드를 호출해서 새 포스트를 저장.
	    postService.create(dto);
	    
	    // 포스트 목록 페이지로 리다이렉트
	    String url = request.getContextPath() + "/post/list" ;
	    log.debug("redirected url = {}", url);
	    
	    response.sendRedirect(url);
	}

}
