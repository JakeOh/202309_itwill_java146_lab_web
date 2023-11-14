<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- JSP 주석
  1. Servlet(Server + Applet)의 동작 방식:
     - Servlet: WAS에서 실행되는, 요청을 처리하고 응답을 보낼 수 있는 작은 자바 프로그램.
     - 서블릿 객체 생성과 관리, 서블릿 메서드 호출은 WAS가 담당.
     - 최초 요청 -> 서블릿 (생성자 호출) 객체 생성 -> 메서드(doGet, doPost, ...) 호출 -> 응답
     - 요청 -> 생성된 서블릿 객체에서 메서드 호출 -> 응답
  2. JSP(Java/Jakarta Server Page)
     - 서블릿은 순수 자바 클래스 코드이기 때문에 HTML을 작성하기가 힘듦.
     - HTML 형식의 파일에서 자바 코드들이 실행될 수 있도록 만든 server-side 문법.
--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP 1</title>
    </head>
    <body>
        <h1>JSP 소개</h1>
    </body>
</html>
