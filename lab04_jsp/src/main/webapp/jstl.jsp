<%@ page import="com.itwill.jsp1.model.Contact"%>
<%@ page import="java.util.ArrayList"%>
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
        pageContext.setAttribute("sites", sns); //-> 문자열 배열을 EL에서 사용하기 위해서.
        %>
        
        <h2>스크립트릿, 식 사용</h2>
        <ul>
        <% for (String s : sns) { %>
            <li><%= s %></li>
        <% } %>
        </ul>
        
        <h2>JSTL, EL 사용</h2>
        <ul>
            <c:forEach var="x" items="${sites}">
            <li>${x}</li>
            </c:forEach>
        </ul>
        
        <h2>JSTL, EL을 사용한 테이블</h2>
        <% 
        // Contact 타입 10개를 저장하는 더미 데이터를 만들고, EL에서 사용할 수 있도록 설정.
        ArrayList<Contact> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Contact(i, "name-" + i, "phone-" + i, "email-" + i));
        }
        pageContext.setAttribute("list", list);
        %>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="c" items="${list}">
                    <tr>
                        <td>${c.id}</td> <%-- EL은 프로퍼티 이름으로 getter 메서드를 찾음. --%>
                        <td>${c.name}</td>
                        <td>${c.phone}</td>
                        <td>${c.email}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
