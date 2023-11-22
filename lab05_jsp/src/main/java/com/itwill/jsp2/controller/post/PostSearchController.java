package com.itwill.jsp2.controller.post;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.dto.PostListItemDto;
import com.itwill.jsp2.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostSearchController
 */
@WebServlet(name = "postSearchController", urlPatterns = { "/post/search" })
public class PostSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostSearchController.class);

	private final PostService postService = PostService.getInstance();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doGet()");
		
		// 요청 파라미터 catetory(검색 타입), keyword(검색어) 찾기:
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		log.debug("--- catetory={}, keyword={}", category, keyword);
		
		// 서비스 호출
		List<PostListItemDto> list = postService.search(category, keyword);
		// 검색 결과를 요청 속성(request attribute)에 추가.
		request.setAttribute("posts", list);
		
		// 검색 결과 페이지(뷰)로 전달.
		request.getRequestDispatcher("/WEB-INF/post/list.jsp")
		    .forward(request, response);
	}

}
