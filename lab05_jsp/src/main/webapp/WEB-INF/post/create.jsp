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
            <h1>새 포스트 작성 페이지</h1>
        </header>
        
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/" />
                    <a href="${mainPage}">메인 페이지</a>
                </li>
                <li>
                    <c:url var="postList" value="/post/list" />
                    <a href="${postList}">포스트 목록 페이지</a>
                </li>
            </ul>
        </nav>
        
        <main class="my-2">
            <div class="card p-2">
                <c:url var="postCreate" value="/post/create" />
                <form action="${postCreate}" method="post">
                    <div class="my-2">
                        <input class="form-control" 
                            type="text" name="title" placeholder="제목" autofocus required />
                    </div>
                    <div class="my-2">
                        <textarea class="form-control"
                            name="content" rows="5" cols="80" placeholder="내용" required></textarea>
                    </div>
                    <div class="my-2">
                        <input class="form-control"
                            type="text" name="author" placeholder="작성자" required />
                    </div>
                    <div class="my-2">
                        <input class="form-control btn btn-success" 
                            type="submit" value="작성완료" />
                    </div>
                </form>
            </div>
        </main>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
