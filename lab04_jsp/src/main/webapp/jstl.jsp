<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
		<h1>JSTL</h1>
        <h2>Jakarta(JSP) Standard Tag Library</h2>
        <%-- JSTL 라이브러리 사용하기
          1. pom.xml에 의존성(dependency)을 추가.
             - jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0
             - org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1
          2. JSTL을 사용하는 JSP 파일에서 taglib 지시문(directive)를 설정.
        --%>
        
        <%
        // HTML 리스트 아이템으로 사용할 더미 데이터:
        String[] sns = { "인*그램", "너튜브", "얼굴책" };
        pageContext.setAttribute("sns", sns); //-> 문자열 배열을 EL에서 사용하기 위해서.
        %>
        
        <h2>스크립트릿, 식 사용</h2>
        <ul>
        <% for (String s : sns) { %>
            <li><%= s %></li>
        <% } %>
        </ul>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
