<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Spring 2</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
	<div class="container-fluid">
        <!-- header -->
        <c:set var="title" value="포스트 작성" />
        <%@ include file="../fragments/title.jspf" %>
        
        <!-- navigation -->
        <%@ include file="../fragments/navigation.jspf" %>
        
        <main class="my-2">
            <div class="my-2 card">
                <c:url var="postCreatePage" value="/post/create" />
                <form class="card-body" action="${postCreatePage}" method="post">
                    <div class="my-2">
                        <input class="form-control" 
                            type="text" name="title" placeholder="제목" required autofocus />
                    </div>
                    <div class="my-2">
                        <textarea class="form-control" rows="5" 
                            name="content" placeholder="내용" required></textarea>
                    </div>
                    <div class="d-none">
                        <!-- 작성자 아이디는 로그인한 사용자 아이디로 설정. -->
                        <input class="form-control" 
                            type="text" name="author" value="${signedInUser}" readonly />
                    </div>
                    <div class="my-2">
                        <input class="form-control btn btn-success" 
                            type="submit" value="작성완료" />
                    </div>
                </form>
            </div>
        </main>
        
    </div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
