<%@ page import="com.itwll.jsp1.model.Contact"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP1</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
		<h1>JSP scriptlet 활용</h1>
        <%--
            scriptlet: JSP 안에서 자바 코드들을 작성하기 위한 태그.
            지역 변수 선언 & 초기화, 객체 생성, 메서드 호출, 조건문, 반복문, ...
        --%>
        
        <%-- html 테이블 작성에 필요한 더미 데이터 생성 --%>
        <% 
        ArrayList<Contact> data = new ArrayList<>(); // 더미 데이터를 저장할 리스트.
        for (int i = 1; i <= 10; i++) {
            // Contact 타입 객체 생성:
            Contact contact = new Contact(i, "이름_" + i, "전화번호_" + i, "이메일_" + i);
            data.add(contact); // 리스트에 연락처를 저장.
        }
        %>
		
        <h2>스크립트릿 사용한 테이블 작성</h2>
        <table class="table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>전화번호</th>
                    <th>이메일</th>
                </tr>
            </thead>
            <tbody>
                <% 
                for (Contact c : data) {
                    out.write("<tr>"); // JSP 내장 객체 out을 사용한 HTML 코드 출력
                    out.write("<td>" + c.getId() + "</td>");
                    out.write("<td>" + c.getName() + "</td>");
                    out.write("<td>" + c.getPhone() + "</td>");
                    out.write("<td>" + c.getEmail() + "</td>");
                    out.write("</tr>");
                }
                %>
            </tbody>
        </table>
        
        <h2>스크립트릿과 식을 사용한 테이블 작성</h2>
        <table>
            <thead>
                <tr>
                    <th>NO.</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                </tr>
            </thead>
            <tbody>
                <% for (Contact c : data) { %>
                <tr>
                    <td><%= c.getId() %></td>
                    <td><%= c.getName() %></td>
                    <td><%= c.getPhone() %></td>
                    <td><%= c.getEmail() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <h2>Unordered List</h2>
        <%-- 스크립트릿과 식을 사용해서 연락처의 이름들을 ul로 작성. --%>
        
        <h2>Description List</h2>
        <%-- 스크립트릿과 식을 사용해서 dl을 작성(dt: 이름, dd: 전화번호와 이메일) --%>
        
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
