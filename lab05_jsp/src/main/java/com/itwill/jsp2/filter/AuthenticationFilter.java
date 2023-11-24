package com.itwill.jsp2.filter;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter extends HttpFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	        throws IOException, ServletException {
		//log.debug("doFilter 호출 전 ---->");
		
		// 인증이 필요한 요청 주소들(예: 새 포스트, 상세보기)에 대해서 로그인 여부를 확인하고,
		// 로그인 안 돼 있으면, 서블릿으로 요청을 보내지 말고 로그인 페이지로 이동(redirect).
		// 로그인 되어 있으면, (서블릿으로 요청을 전달해서) 계속 요청을 처리.

	    HttpServletRequest req = (HttpServletRequest) request;
	    
	    // 필터로 들어온 요청(request)의 정보(요청 주소, ...)
//	    log.debug("URL: {}", req.getRequestURL()); //-> (예) http://localhost:8081/jsp2/post/details
//	    log.debug("URI: {}", req.getRequestURI()); //-> (예) /jsp2/post/details
//	    log.debug("query string: {}", req.getQueryString()); //-> (예) id=1
	    
	    String reqUrl = req.getRequestURL().toString(); // 요청 주소(URL)
	    String qs = req.getQueryString(); // 질의 문자열(query string)
	    String target = ""; // 로그인 성공하면 이동(redirect)할 타겟 주소
	    if (qs == null) { // 질의 문자열이 없는 경우
	        target = URLEncoder.encode(reqUrl, "UTF-8");
	    } else { // 질의 문자열이 있는 경우
	        target = URLEncoder.encode(reqUrl + "?" + qs, "UTF-8");
	    }
	    log.debug("target={}", target);
	    
		HttpSession session = req.getSession();
		Object signedInUser = session.getAttribute("signedInUser");
		if (signedInUser == null) { // 로그인 안 된 상태
		    log.debug("로그아웃 상태 ---> 로그인 페이지로 이동");
		    
		    String url = req.getContextPath() + "/user/signin?target=" + target; // 로그인 페이지
		    ((HttpServletResponse) response).sendRedirect(url);
		} else { // 로그인된 상태
		    log.debug("로그인 상태: {}", signedInUser);
		    
		    chain.doFilter(request, response); // 요청을 계속 처리.
		}
		
		//log.debug("----> doFilter 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// Auto-generated method stub
	}

}
