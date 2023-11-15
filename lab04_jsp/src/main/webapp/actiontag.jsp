<%@ page import="com.itwill.jsp1.model.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 1</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
    
        <nav>
            <ul>
                <li>
                    <a href="/jsp1">인덱스 페이지</a>
                </li>
            </ul>
        </nav>
		
        <h1>JSP Action Tag</h1>
        <%-- 
          JSP 액션 태그: 스크립트릿에서 사용되는 자바 코드들을 HTML 또는 XML 파일과 비슷하게
          태그, 태그 속성 설정, 태그 컨텐트를 작성해서 대체하는 기능.
          액션 태그는 대소문자를 구분!
          o. <jsp:forward></jsp:forward>
          o. <jsp:include></jsp:include>
          o. <jsp:useBean></jsp:useBean>: 생성자
          o. <jsp:getProperty></jsp:getProperty>: getter 메서드
          o. <jsp:setProperty></jsp:setProperty>: setter 메서드
        --%>
        
        <h2>액션 태그 없이 객체 생성</h2>
        <%
        Contact c1 = new Contact(); // 기본 생성자 호출 -> 객체 생성.
        c1.setId(100); // setter 호출.
        c1.setName("홍길동");
        %>
        <p class="card m-2">
            c1: <%=c1%> <%-- c1.toString() --%>
            <br/>
            ID: <%=c1.getId()%>
            <br/>
            이름: <%=c1.getName()%>
        </p>
        
        <h2>액션 태그를 사용한 객체 생성</h2>
        <jsp:useBean id="c2" class="com.itwill.jsp1.model.Contact"></jsp:useBean>
        <jsp:setProperty property="id" name="c2" value="200" />
        <jsp:setProperty property="name" name="c2" value="오쌤" />
        <p class="card m-2">
            ID: <jsp:getProperty property="id" name="c2"/>
            <br/>
            이름: <jsp:getProperty property="name" name="c2"/>
        </p>
        
        <%-- 아규먼트가 있는 생성자 호출: --%>
        <jsp:useBean id="c3" class="com.itwill.jsp1.model.Contact">
            <jsp:setProperty name="c3" property="id" value="300" />
            <jsp:setProperty name="c3" property="name" value="아이티윌" />
            <jsp:setProperty name="c3" property="phone" value="02-1234-5678" />
            <jsp:setProperty name="c3" property="email" value="admin@itwill.com" />
        </jsp:useBean>
        <p class="card m-2">
            ID: <jsp:getProperty property="id" name="c3"/>
            <br/>
            이름: <jsp:getProperty property="name" name="c3"/>
            <br/>
            전화번호: <jsp:getProperty property="phone" name="c3"/>
            <br/>
            이메일: <jsp:getProperty property="email" name="c3"/>
        </p>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
