package com.itwill.jsp2.controller.user;

import java.io.IOException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.jsp2.domain.User;
import com.itwill.jsp2.dto.UserSignInDto;
import com.itwill.jsp2.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSignInController
 */
@WebServlet(name = "userSignInController", urlPatterns = { "/user/signin" })
public class UserSignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserSignInController.class);
	
	private final UserService userService = UserService.getInstance();
       
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    log.debug("doGet()");
	    
	    request.getRequestDispatcher("/WEB-INF/user/signin.jsp")
	        .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
		log.debug("doPost()");
	    
	    // 요청 파라미터 userid, password를 찾음.
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
//		UserSignInDto dto = new UserSignInDto(userid, password);
		UserSignInDto dto = UserSignInDto.builder()
		        .userid(userid).password(password).build();
		log.debug("dto={}", dto);
		
	    // 서비스 메서드를 호출하면서 로그인 정보를 전달.
		User signedInUser = userService.signIn(dto);
		
	    // 성공이면 포스트 목록 페이지로 이동, 실패면 로그인 페이지로 이동.
		String target = request.getParameter("target"); // 로그인 성공 시 이동할 페이지(타겟)
        log.debug("target={}", target);
        
		if (signedInUser != null) {
		    HttpSession session = request.getSession();
		    //-> 세션이 생성되어 있지 않은 경우에는 새로운 세션 객체를 생성해서 리턴,
		    //-> 세션이 이미 생성되어 있는 경우에는 기존 세션을 리턴.
		    
		    session.setAttribute("signedInUser", signedInUser.getUserid());
		    //-> 세션에 로그인 성공한 사용자의 아이디를 저장.
		    
		    // 로그인 성공인 경우에는 요청 파라미터 target의 값으로 이동(redirect)
		    response.sendRedirect(target);
		    
		} else {
		    String url = request.getContextPath() 
		            + "/user/signin?result=fail&target="
		            + URLEncoder.encode(target, "UTF-8");
		    response.sendRedirect(url);
		}
	}

}
