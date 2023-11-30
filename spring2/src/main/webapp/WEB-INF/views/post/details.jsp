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
        <c:set var="title" value="포스트 상세보기" />
        <%@ include file="../fragments/title.jspf" %>
        
        <!-- navigation -->
        <%@ include file="../fragments/navigation.jspf" %>
        
        <main class="my-2">
            <div class="card">
                <form class="card-body">
                    <div class="my-2">
                        <label class="form-label" for="id">번호</label>
                        <input class="form-control" id="id" 
                            type="text" value="${post.id}" readonly />
                    </div>
                    <div class="my-2">
                        <label class="form-label" for="title">제목</label>
                        <input class="form-control" id="title" 
                            type="text" value="${post.title}" readonly />
                    </div>
                    <div class="my-2">
                        <label class="form-label" for="content">내용</label>
                        <textarea class="form-control" id="content" readonly>${post.content}</textarea>
                    </div>
                    <div class="my-2">
                        <label class="form-label" for="author">작성자</label>
                        <input class="form-control" id="author" 
                            type="text" value="${post.author}" readonly />
                    </div>
                    <div class="my-2">
                        <label class="form-label" for="createdTime">작성시간</label>
                        <input class="form-control" id="createdTime" 
                            type="text" value="${post.created_time}" readonly />
                    </div>
                    <div class="my-2">
                        <label class="form-label" for="modifiedTime">수정시간</label>
                        <input class="form-control" id="modifiedTime" 
                            type="text" value="${post.modified_time}" readonly />
                    </div>
                </form>
                <div class="card-footer">
                    <c:url var="postModifyPage" value="/post/modify">
                        <c:param name="id" value="${post.id}" />
                    </c:url>
                    <a href="${postModifyPage}" class="btn btn-primary">수정하기</a>
                </div>
            </div>
        </main>	
	
    </div>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	    crossorigin="anonymous"></script>
	</body>
</html>
