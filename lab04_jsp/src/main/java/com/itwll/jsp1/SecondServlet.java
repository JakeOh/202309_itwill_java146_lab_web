package com.itwll.jsp1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
// 서블릿 URL(요청 주소) 매핑 방법:
// 1. web.xml (배포 관리자, deployment descriptor)에서 <servlet>, <servlet-mapping> 설정하거나,
// 2. 서블릿 클래스에서 @WebServlet 애너테이션으로 설정.
// (주의) web.xml 또는 애너테이션 둘 중 하나만 설정. 둘 다 설정할 수는 없음.
@WebServlet(name = "secondServlet", urlPatterns = { "/ex2" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("secondServlet::doGet() 메서드 호출");
		
		// 서버가 클라이언트로 보내는 응답(response)의 컨텐트 타입을 설정:
		// 한글 인코딩을 설정해서 한글이 깨지지 않도록 하기 위해서.
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.append("<html>")
		    .append("<body>")
		    .append("<h1>두번째 서블릿</h1>")
		    .append("<a href='/jsp1'>인덱스 페이지</a>")
		    .append("</body>")
		    .append("</html>");
	}

}
