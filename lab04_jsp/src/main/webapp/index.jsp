<%@ page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>JSP</title>
    </head>
    <body>
        <h1>인덱스 페이지</h1>
        <h2><%= LocalDateTime.now() %></h2>
        
        <ul>
            <li>
                <a href="ex1">첫번째 서블릿</a>
            </li>
            <li>
                <a href="ex2">두번째 서블릿</a>
            </li>
            <li>
                <a href="ex3">포워드(Forward)</a>
            </li>
            <li>
                <a href="ex4">리다이렉트(Redirect)</a>
            </li>
            <li>
                <a href="intro.jsp">JSP 소개</a>
            </li>
            <li>
                <a href="form.jsp">폼 양식</a>
            </li>
            <li>
                <a href="main.jsp">include 지시문(directive)</a>
            </li>
        </ul>
    </body>
</html>
