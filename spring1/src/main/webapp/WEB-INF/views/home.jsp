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
            <h1>메인 페이지</h1>
            <h2>${now}</h2>
        </header>
        
        <nav>
            <ul>
                <li>
                    <c:url var="ex1Page" value="/ex1" />
                    <a href="${ex1Page}">ex1</a>
                </li>
                <li>
                    <c:url var="test" value="/test" />
                    <a href="${test}">테스트</a>
                </li>
                <li>
                    <c:url var="forwardPage" value="/forward" />
                    <a href="${forwardPage}">포워드</a>
                </li>
                <li>
                    <c:url var="redirectPage" value="/redirect" />
                    <a href="${redirectPage}">리다이렉트</a>
                </li>
                <li>
                    <c:url var="rest1Page" value="/rest1" />
                    <a href="${rest1Page}">REST Controller 1</a>
                </li>
                <li>
                    <c:url var="rest2Page" value="/rest2" />
                    <a href="${rest2Page}">REST Controller 2</a>
                </li>
                <li>
                    <c:url var="rest3Page" value="/rest3" />
                    <a href="${rest3Page}">REST Controller 3</a>
                </li>
                <li>
                    <c:url var="rest4Page" value="/rest4" />
                    <a href="${rest4Page}">REST Controller 4</a>
                </li>
            </ul>
        </nav>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
