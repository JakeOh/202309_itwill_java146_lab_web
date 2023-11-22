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
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("----- filterEx1: doFilter() 호출 전");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("----- filterEx2: doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filterEx1::init() 호출");
	}

}
