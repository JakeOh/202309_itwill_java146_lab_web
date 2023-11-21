package com.itwill.jsp2.controller.post;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet(name = "postDeleteController", urlPatterns = { "/post/delete" })
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDeleteController.class);
	
	private final PostService postService = PostService.getInstance();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doGet()");
		
		// 요청 파라미터 id를 찾음.
		Long id = Long.valueOf(request.getParameter("id"));
		log.debug("--- id={}", id);
		
		// 서비스(비즈니스) 계층의 메서드를 호출해서 포스트를 삭제.
		postService.delete(id);
		
		// 포스트 목록 페이지로 리다이렉트
		response.sendRedirect("/jsp2/post/list");
		
	}

}
