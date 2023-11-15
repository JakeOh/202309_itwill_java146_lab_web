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
		
        <%-- 정보 저장 JSP 내장 객체:
          o. pageContext: JSP 페이지가 유지되는 동안 정보 저장.
          o. request: 요청 객체가 유지되는 동안 정보 저장.
          o. session: 세션이 유지되는 동안 정보 저장.
          o. application: 웹 애플리케이션이 동작하는 동안 정보 저장.
          o. 사용 범위: pageContext < request < session < application
        --%>
        
        <%
        // setAttribute("속성이름", 속성값)
        // getAttribute("속성이름")
        pageContext.setAttribute("var", 1); // pageContext에 정보 저장.
        request.setAttribute("var", "hello"); // request에 정보 저장.
        session.setAttribute("var", "admin"); // session에 정보 저장.
        %>
        
        <h2>식(expression)을 사용한 상태 정보 읽기</h2>
        <p>
        pageVar = <%= pageContext.getAttribute("var") %> <br/>
        reqVar = <%= request.getAttribute("var") %> <br/>
        sessionVar = <%= session.getAttribute("var") %>
        </p>
        
        <h2>EL을 사용한 상태 정보 읽기</h2>
        <%-- 
          EL에서 상태 정보를 저장하는 객체 이름:
          o. pageScope - JSP pageContext
          o. requestScope - JSP request
          o. sessionScope - JSP session
          o. applicationScope - JSP application
          o. 사용 범위: pageScope < requestScope < sessionScope < applicationScope
        --%>
        <p>
        page var = ${ pageScope.var } <br/>
        request var = ${ requestScope.var } <br/>
        session var = ${ sessionScope.var } <br/>
        var = ${ var }
        </p>
        
        <%-- EL에서 변수를 찾는 순서: ${ var }
          (1) ${ pageScope.var }
          (2) ${ requestScope.var }
          (3) ${ sessionScope.var }
          (4) ${ applicationScope.var }
        --%>
        
        <h2>EL 삼항 연산자</h2>
        <% pageContext.setAttribute("number", 123); %>
        <p>${ number } = ${ (number % 2 == 1) ? '홀수' : '짝수' }</p>
        
        <% session.setAttribute("logInUser", "admin"); %>
        <p>${ (logInUser != null) ? '안녕하세요,' : '로그인하세요' } ${ logInUser }</p>
        
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
