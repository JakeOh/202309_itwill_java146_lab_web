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
		<h1>폼 양식 데이터 제출 처리 결과</h1>
        
        <%
        // 클라이언트에서 보낸 요청 파라미터(request parameter)의 값을 찾는 방법:
        // getParameter() 메서드의 아규먼트는 input name 속성 값을 사용.
        String username = request.getParameter("username");
        %>
        
        <%-- JSP 내장 객체:
          JSP가 Java로 변환될 때 _jspService(request, response) 메서드 안에서 선언된 지역 변수들.
          스크립트릿(scriptlet), 식(expression)에서 변수 선언 없이 바로 사용할 수 있는 변수들.
          스크립트릿에서 지역 변수 선언으로 사용할 수 없음.
          o. request: 클라이언트에서 서버로 보내는 요청 정보들과 메서드들을 가지고 있는 객체.
          o. response: 서버에서 응답을 만들 때 사용하는 객체.
          o. pageContext: JSP 페이지가 유지되는 동안 정보를 저장하기 위한 객체.
          o. session: 세션이 유지되는 동안 정보를 저장하기 위한 객체. (예) 로그인 유지.
          o. application: 웹 애플리케이션이 동작 중에 유지되는 정보드를 저장하기 위한 객체.
          o. config: 서블릿 환경 설정 정보를 저장하는 객체.
          o. out: JSP Writer. HTML 코드를 작성하는 기능을 가지고 있는 객체.
        --%>
        
        <h2>안녕하세요, <%= username %>!</h2>
        
        <a href="/jsp1">인덱스 페이지</a>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
