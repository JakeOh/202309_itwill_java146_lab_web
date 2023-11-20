<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 2</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
		<header class="my-2 p-4 bg-dark text-white text-center">
            <h1>메인 페이지</h1>
        </header>
        
        <!-- 내비게이션 메뉴 -->
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <c:url var="postList" value="/post/list" />
                    <a class="nav-link" href="${postList}">포스트 목록 페이지</a>
                </li>
            </ul>
        </nav>
        
        <!-- 메인 컨텐트 -->
        <main></main>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
