package com.itwill.jsp1.controller;

import java.io.IOException;

import com.itwill.jsp1.model.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet(name = "contactServlet", urlPatterns = { "/mvc" })
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("contactServlet::doGet() 호출");
		
		// 컨트롤러에서 뷰(view)를 호출(뷰로 요청을 전달).
		request.getRequestDispatcher("/WEB-INF/contact_form.jsp")
		    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		System.out.println("contactServlet::doPost() 호출");
		
		// 클라이언트가 보낸 요청 파라미터들을 읽음.
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		// Contact 타입 객체 생성
		Contact contact = new Contact(id, name, phone, email);
		System.out.println(contact);
		
		// 연락처 DB에 저장함.
		
		// 인덱스 페이지로 리다이렉트(redirect)
		response.sendRedirect("/jsp1");
	}

}
