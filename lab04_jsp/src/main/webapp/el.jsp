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
		<h1>EL(Expression Language): (표현)식 언어</h1>
        <%--
          EL: JSP의 expression(식) <%= ... %>을 대체하는 문법.
          문법: ${ 식 }
          * 지시문 <%@ ... %> 안에서는 사용할 수 없음.
          * 선언문 <%! ... %> 안에서는 사용할 수 없음.
          * 스크립트릿 <% ... %> 안에서는 사용할 수 없음.
          * 식 <%= ... %> 안에서는 사용할 수 없음.
          * 그 이외의 JSP 코드에서는 언제든지 사용할 수 있음!
            - HTML 태그의 컨텐트, 속성 값 설정
            - CSS 속성(property) 값 설정
            - JavaScript 코드 안에서
            - JSTL 안에서 
        --%>
        
        <p><%= 1 + 1 %></p> <%-- JSP expression --%>
        <p>${ 1 + 1 }</p> <%-- EL --%>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
