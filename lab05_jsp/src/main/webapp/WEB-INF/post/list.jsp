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
            <h1>포스트 목록 페이지</h1>
        </header>
        
        <c:set var="targetURL" value="http://localhost:8081/jsp2/post/list" />
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
                        <%-- 세션에 signedInUser 속성이 있으면(로그인되어 있으면) --%>
                        <c:if test="${not empty signedInUser}">
                            <li class="nav-item">
                                <c:url var="signOutPage" value="/user/signout" />
                                <a class="nav-link" href="${signOutPage}">
                                    <span>${signedInUser}</span> 로그아웃
                                </a>
                            </li>
                        </c:if>
                        <%-- 세션에 signedInUser 속성이 없으면(로그인되이 있지 않으면) --%>
                        <c:if test="${empty signedInUser}">
                            <li class="nav-item">
                                <c:url var="signInPage" value="/user/signin">
                                    <c:param name="target" value="${targetURL}" />
                                </c:url>
                                <a class="nav-link" href=${signInPage}>로그인</a>
                            </li>
                            <li class="nav-item">
                                <c:url var="signUpPage" value="/user/signup" />
                                <a class="nav-link" href="${signUpPage}">회원가입</a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        
        <main class="my-2">
            <div class="card p-2">
                <div class="card-header my-2">
                    <c:url var="searchPage" value="/post/search" />
                    <form action="${searchPage}" method="get">
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
                <table class="table table-striped card-body my-2">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>수정시간</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${posts}">
                        <tr>
                            <td>${p.id}</td>
                            <td>
                                <c:url var="postDetails" value="/post/details">
                                    <c:param name="id" value="${p.id}" />
                                </c:url>
                                <a href="${postDetails}">${p.title}</a>
                            </td>
                            <td>${p.author}</td>
                            <td>${p.modifiedTime}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
