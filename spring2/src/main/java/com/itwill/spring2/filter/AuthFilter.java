package com.itwill.spring2.filter;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet Filter implementation class AuthFilter
 */
@Slf4j
public class AuthFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO WAS(Tomcat)가 종료될 때 필터가 사용했던 리소스 등을 해제하기 위해서.
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		// 필터 체인의 다음 필터 또는 서블릿으로 요청이 전달되기 전에 할 일 작성.
	    // 로그인되어 있는 지를 확인해서, 
	    // (1) 로그인되어 있으면, 요청을 계속 진행.
	    // (2) 로그인되어 있지 않으면, 
	    // "로그인 후 이동할 페이지(타겟) 정보를 포함"해서 로그인 페이지로 이동.

	    log.debug("doFilter()");
	    
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(); // 요청 객체에서 세션 찾기.
		Object signedInUser = session.getAttribute("signedInUser"); // 세션에서 로그인 정보 찾기.
		if (signedInUser != null) { // 세션에 로그인 정보가 있으면
		    log.debug("로그인 상태: {}", signedInUser);
		    
		    // 요청을 필터 체인의 다음 단계(다음 필터 또는 서블릿)로 전달.
		    chain.doFilter(request, response);
		    
		} else { // 세션에 로그인 정보가 없으면
		    log.debug("로그아웃 상태 ---> 로그인 페이지로 이동");
		    
		    // 필터로 들어온 요청 주소(request URL)를 찾음.
		    String reqUrl = httpRequest.getRequestURL().toString();
		    log.debug("요청 주소: {}", reqUrl);
		    
		    // 요청에 쿼리 스트링(질의 문자열)이 있는 지 확인.
		    String qs = httpRequest.getQueryString();
		    log.debug("쿼리 스트링: {}", qs);
		    
		    String target = ""; // 로그인 후 이동할 페이지(타겟) 정보를 저장하기 위한 문자열.
		    if (qs == null) {
		        target = URLEncoder.encode(reqUrl, "UTF-8");
		    } else {
		        target = URLEncoder.encode(reqUrl + "?" + qs, "UTF-8");
		    }
		    log.debug("target: {}", target);
		    
		    // 로그인 페이지로 이동(redirect)
		    String redirectUrl = httpRequest.getContextPath() 
		            + "/user/signin?target="
		            + target;
		    ((HttpServletResponse) response).sendRedirect(redirectUrl);
		}
		
		// 서블릿이 요청 처리를 끝낸 후 응답을 보내기 전에 할 일 작성.
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO WAS(Tomcat)가 필터를 생성하고난 후, 필터의 초기화 작업이 필요한 경우.
	}

}
