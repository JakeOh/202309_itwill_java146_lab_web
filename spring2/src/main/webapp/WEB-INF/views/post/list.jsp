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
        <c:set var="title" value="포스트 목록" />
        <%@ include file="../fragments/title.jspf" %>
    
        <!-- navigation -->
        <%@ include file="../fragments/navigation.jspf" %>
    
        <main class="my-2">
        <!-- 포스트 목록 테이블 -->
            <div class="card">
                <div class="card-header">
                    <c:url var="postSearchPage" value="/post/search" />
                    <form action="${postSearchPage}" method="get">
                        <div class="row">
                            <div class="col-3">
                                <select class="form-control" name="category">
                                    <option value="t">제목</option>
                                    <option value="c">내용</option>
                                    <option value="tc">제목+내용</option>
                                    <option value="a">작성자</option>
                                </select>
                            </div>
                            <div class="col-6">
                                <input class="form-control" type="text" 
                                    name="keyword" placeholder="검색어" required autofocus />
                            </div>
                            <div class="col-3">
                                <input class="form-control btn btn-secondary" 
                                    type="submit" value="검색" />
                            </div>
                        </div>
                    </form>
                </div>
                <table class="card-body table table-hover">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>수정시간</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="post" items="${posts}">
                        <tr>
                            <td>${post.id}</td>
                            <c:url var="postDetailsPage" value="/post/details">
                                <c:param name="id" value="${post.id}" />
                            </c:url>
                            <td><a href="${postDetailsPage}">${post.title}</a></td>
                            <td>${post.author}</td>
                            <td>${post.modifiedTime}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
	</div>	
		
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	    crossorigin="anonymous"></script>
	</body>
</html>
