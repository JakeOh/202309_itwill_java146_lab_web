package com.itwill.jsp1.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class FilterEx2
 */
// 필터 매핑 설정:
// (1) web.xml 에서 <filter>, <filter-mapping> 태그에서 설정하거나
// (2) @WebFilter 애너테이션으로 설정.
@WebFilter(filterName = "filterEx2", urlPatterns = { "/ex2", "/mvc" })
public class FilterEx2 extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterEx2() {
        System.out.println("생성자 FilterEx2() 호출");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("----- filterEx2: doFilter() 호출 전");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		System.out.println("----- filterEx2: doFilter() 호출 후");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
