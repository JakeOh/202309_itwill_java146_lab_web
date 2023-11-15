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
		<%-- include directive(지시문)을 사용한 jsp/jspf 파일 삽입: 
          여러 개의 페이지가 공통된 컨텐트(예: 헤더, 푸터)를 포함하는 경우,
          공통된 컨텐트를 별도의 jsp/jspf 파일로 작성하고
          필요한 페이지들에서 jsp/jspf를 포함해서 사용하는 방식.
          - 동작방식: include 지시문이 사용된 위치에 jsp/jspf 파일의 내용이 삽입되고,
          하나의 자바 클래스 파일로 변환되서 컴파일 됨.
        --%>
        
        <%@ include file="header.jsp" %>
        
        <main class="card m-2">
            <h1>메인 페이지</h1>
            <nav>
                <ul>
                    <li>
                        <a href="/jsp1">인덱스 페이지</a>
                    </li>
                </ul>
            </nav>
        </main>
        
        <%@ include file="footer.jspf" %>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
