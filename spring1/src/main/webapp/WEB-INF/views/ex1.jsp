<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring 1</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
		<header>
            <h1>Ex1 페이지</h1>
        </header>
        
        <nav>
            <li>
                <c:url var="homePage" value="/" />
                <a href="${homePage}">메인 페이지</a>
            </li>
        </nav>
        
        <main>
            <h2>GET 요청</h2>
            <c:url var="ex2" value="/ex2" />
            <form action="${ex2}" method="get">
                <input type="text" name="username" placeholder="사용자 이름" />
                <input type="number" name="age" placeholder="나이" />
                <input type="submit" value="제출" />
            </form>
            
            <h2>POST 요청</h2>
            <c:url var="ex3" value="/ex3" />
            <form action="${ex3}" method="post">
                <input type="text" name="username" placeholder="사용자 이름" />
                <input type="number" name="age" placeholder="나이" />
                <input type="submit" value="제출" />
            </form>
        </main>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
