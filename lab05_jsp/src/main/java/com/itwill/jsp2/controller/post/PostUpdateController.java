package com.itwill.jsp2.controller.post;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.dto.PostUpdateDto;
import com.itwill.jsp2.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostUpdateController
 */
@WebServlet(name = "postUpdateController", urlPatterns = { "/post/update" })
public class PostUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostUpdateController.class);
	
	private final PostService postService = PostService.getInstance();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doPost()");
		
		// 요청 파라미터 id, title, content를 찾음
		Long id = Long.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PostUpdateDto dto = new PostUpdateDto(id, title, content);
		log.debug("dto={}", dto);
		
		// 서비스(비즈니스) 계층의 메서드 호출 -> 포스트 업데이트.
		postService.update(dto);
		
		String url = request.getContextPath() + "/post/details?id=" + id;
		response.sendRedirect(url);
	}

}
