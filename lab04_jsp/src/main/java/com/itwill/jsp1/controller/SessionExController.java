package com.itwill.jsp1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class SessionExController
 */
@WebServlet(name = "sessionExController", urlPatterns = { "/exsession" })
public class SessionExController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("sessionExController::doGet() 호출");
		
		// 서버가 저장하는 클라이언트마다 매핑되어 있는 세션 객체를 찾음.
		// (1) 클라이언트가 JSESSIONID 쿠키를 보내면, 세션 아이디를 사용해서 세션 객체를 찾음.
		// (2) 클라이언트가 보낸 쿠키에 세션 아이디가 없는 경우에는 새로운 세션 객체를 생성.
		HttpSession session = request.getSession();
		System.out.println(session);
		
		session.setAttribute("nickname", "관리자");
		
		request.getRequestDispatcher("/WEB-INF/session.jsp")
		    .forward(request, response);
	}

}
