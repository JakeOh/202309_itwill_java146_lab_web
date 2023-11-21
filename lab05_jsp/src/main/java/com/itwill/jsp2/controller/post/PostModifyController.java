package com.itwill.jsp2.controller.post;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.Post;
import com.itwill.jsp2.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostModifyController
 */
@WebServlet(name = "postModifyController", urlPatterns = { "/post/modify" })
public class PostModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostModifyController.class);
	
	private final PostService postService = PostService.getInstance();
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		// 요청 파라미터 id 찾음 -> 서비스 메서드 호출 -> 요청 객체에 속성 추가 -> 뷰로 전달
	    log.debug("doGet()");
	    
	    Long id = Long.valueOf(request.getParameter("id"));
	    log.debug("--- id={}", id);
	    
	    Post post = postService.read(id);
	    request.setAttribute("post", post);
	    
	    request.getRequestDispatcher("/WEB-INF/post/modify.jsp")
	        .forward(request, response);
	}

}
