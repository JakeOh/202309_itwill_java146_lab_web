package com.itwill.jsp1.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterEx1
 */
public class FilterEx1 extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterEx1() {
        System.out.println("생성자 FilterEx1()");
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
    public void destroy() {
		System.out.println("filterEx1::destroy() 호출");
		// WAS가 종료될 때 생성된 필터를 소멸시킬 때 호출 - 리소스 해제
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청을 필터 체인(-> 서블릿)으로 전달하기 전에 실행할 코드들:
	    System.out.println("----- filterEx1: doFilter() 호출 전");

		// pass the request along the filter chain - 요청을 필터 체인으로 전달 -> 서블릿 실행
		chain.doFilter(request, response);
		
		// 요청 처리가 끝난 후에 실행할 코드들
		System.out.println("----- filterEx1: doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filterEx1::init() 호출");
		// 필터가 생성된 후 초기화 작업 수행 - 필터 환경 설정(configuration)를 이용.
	}

}
