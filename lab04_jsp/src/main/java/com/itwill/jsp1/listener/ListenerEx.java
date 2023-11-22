package com.itwill.jsp1.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ListenerEx
 *
 */
// 리스너 설정
// (1) web.xml <listener> 에서 설정하거나
// (2) @WebListener 애너테이션으로 설정.
public class ListenerEx implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerEx() {
        System.out.println("생성자 ListenerEx() 호출");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("컨텍스트 초기화됨...");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("컨텍스트 소멸됨...");
    }
	
}
