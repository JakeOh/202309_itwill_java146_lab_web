package com.itwill.jsp1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet(name = "redirectServlet", urlPatterns = { "/ex4" })
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("redirectServlet::doGet() 호출");
		
		// 클라이언트에서 서버로 온 요청을 "redirect" 방식으로 이동:
		// - 최초 요청 주소가 이동하는 페이지로 바뀜.
		// - 최초 요청의 request, response 객체가 이동하는 페이지로 전달되지 않음.
		// - 같은 웹 서버의 같은 웹 애플리케이션 뿐만 아니라, 외부 서버로도 이동이 가능.
		// request(최초 URL) -> response:redirect -> request(새 URL) -> response
		
//		response.sendRedirect("https://www.google.com/"); //-> 다른 WAS로 이동.
		response.sendRedirect("ex3"); //-> 같은 웹 애플리케이션으로 이동.
	}

}
