package com.itwill.jsp2.controller.post;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class PostListController
 */
@WebServlet(name = "postListController", urlPatterns = { "/post/list" })
public class PostListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostListController.class);

	private final PostService postService = PostService.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doGet()");
		
		// 서비스(비즈니스) 계층의 메서드를 호출해서 뷰에 보여줄 데이터를 가져옴.
		List<Post> list = postService.read();
		// 데이터를 뷰에 보내기 위해서 요청 객체에 속성으로 추가.
		request.setAttribute("posts", list);
		
		// 뷰로 요청을 전달 -> HTML 응답을 보냄.
		request.getRequestDispatcher("/WEB-INF/post/list.jsp")
		    .forward(request, response);
	}

}
