package com.itwll.jsp1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * WAS(Web Application Server): 웹 요청(request)/응답(response) 처리를 하는 프로그램.
 * 서블릿 컨테이너(Servlet Container): 서블릿을 실행시킬 수 있는 환경.
 * 서블릿(Servlet): 서버에서 실행되는 작은 애플리케이션. Server + Applet.
 * Tomcat: WAS (Servlet Containter) 제품 이름.
 */

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    // get 방식의 요청이 왔을 때 웹 서버(Tomcat)가 호출하는 메서드.
		// 파라미터 request: 클라이언트에서 서버로 보낸 요청의 정보, 기능들을 갖는 객체.
	    // 파라미터 response: 서버에서 클라이언트로 보낼 응답의 정보, 기능들을 갖는 객체.
	    
	    System.out.println("firstServlet::doGet() 호출"); // 이클립스 콘솔 메시지
	    
	    PrintWriter out = response.getWriter();
	    out.append("<!doctype html>")
	        .append("<html>")
	        .append("<head>")
	        .append("<meta charset='utf-8' />")
	        .append("</head>")
	        .append("<body>")
	        .append("<h1>첫번째 서블릿</h1>")
	        .append("<a href='/jsp1'>인덱스페이지</a>")
	        .append("</body>")
	        .append("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		// post 방식의 요청이 왔을 때 웹 서버가 호출하는 메서드.
	}

}
