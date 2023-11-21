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
            <h1>포스트 수정 페이지</h1>
        </header>
        
        <nav class="my-2 navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <c:url var="mainPage" value="/" />
                            <a class="nav-link" href="${mainPage}">홈</a>
                        </li>
                        <li class="nav-item">
                            <c:url var="postList" value="/post/list" />
                            <a class="nav-link" href="${postList}">포스트 목록</a>
                        </li>
                        <li class="nav-item">
                            <c:url var="postCreate" value="/post/create" />
                            <a class="nav-link" href="${postCreate}">새 포스트</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        
        <main class="my-2">
            <div class="card">
                <form class="card-body" id="postModifyForm">
                    <div class="my-2">
                        <label for="id" class="form-label">번호</label>
                        <input class="form-control" id="id" name="id"
                            type="number" value="${post.id}" readonly />
                    </div>
                    <div class="my-2">
                        <label for="title" class="form-label">제목</label>
                        <input id="title" class="form-control" name="title"
                            type="text" value="${post.title}" autofocus />
                    </div>
                    <div class="my-2">
                        <label for="content" class="form-label">내용</label>
                        <textarea id="content" class="form-control"
                            name="content">${post.content}</textarea>
                    </div>
                    <div class="my-2">
                        <label for="author" class="form-label">작성자</label>
                        <input id="author" class="form-control" 
                            type="text" value="${post.author}" readonly />
                    </div>
                </form>
                <div class="card-footer">
                    <button id="btnDelete" class="btn btn-danger">삭제</button>
                    <button id="btnUpdate" class="btn btn-success">수정 완료</button>
                </div>
            </div>
        </main>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	   
       <script src="../js/post_modify.js"></script>
       <%-- 
         현재 요청 주소: http://localhost:8081/jsp2/post/modify?id=00
         상대 경로 ./abc => http://localhost:8081/jsp2/post/abc
         상대 경로 ../abc => http://localhost:8081/jsp2/abc
         ../js/modify.js => http://localhost:8081/jsp2/js/modify.js
         
         context root(http://localhost:8081/jsp2)는 WAS의 webapp 디렉토리(폴더)를 의미.
       --%>
    </body>
</html>
