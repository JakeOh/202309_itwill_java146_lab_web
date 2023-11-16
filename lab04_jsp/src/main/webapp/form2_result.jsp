<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<% 
// 쿼리 스트링(질의 문자열)에 포함된 요청 파라미터 값들을 읽음:
String username = request.getParameter("username");
String color = request.getParameter("color");
String colorValue = "black"; // 글자색 기본값
if (color.equals("r")) {
    colorValue = "crimson"; // CSS에서 사용할 수 있는 색상 이름
} else if (color.equals("g")) {
    colorValue = "darkgreen";
} else if (color.equals("b")) {
    colorValue = "dodgerblue";
}
%>

<c:set var="colVal" value="black" />
<c:if test="${param.color == 'r'}">
    <c:set var="colVal" value="red" />
</c:if>
<c:if test="${param.color eq 'g'}">
    <c:set var="colVal" value="green" />
</c:if>
<c:if test="${param.color eq 'b'}">
    <c:set var="colVal" value="blue" />
</c:if>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 1</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
        
        <style>
            span#s1 {
                color: <%= colorValue %>;
            }
            
            span#s2 {
                color: ${colVal}; /* JSTL에서 c:set 태그로 만든 변수 */
            }
        </style>
	</head>
	<body>
		<h1>폼 요청 처리 결과</h1>
        
        <h2>JSP scriptlet, expression 사용</h2>
        <h3>아이디: <span id="s1"><%= username %></span></h3>
		
        <h2>JSTL, EL 사용</h2>
        <h3>아이디: <span id="s2">${param.username}</span></h3>
        <%-- request.getParameter("name")을 대신하는 EL: ${param.name} --%>
        
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
