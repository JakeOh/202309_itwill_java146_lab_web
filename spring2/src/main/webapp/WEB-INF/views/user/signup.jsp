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
        <c:set var="title" value="회원가입" />
        <%@ include file="../fragments/title.jspf" %>
        
        <main class="my-2">
            <div class="mhy-2 card card-body">
                <form>
                    <div class="my-2">
                        <input type="text" class="form-control"
                            id="userid" name="userid" placeholder="userid" required autofocus />
                    </div>
                    <div id="checkIdResult">
                        <!-- TODO: userid 중복체크 결과 표시 -->
                    </div>
                    <div class="my-2">
                        <input type="password" class="form-control"
                            id="password" name="password" placeholder="password" required />
                    </div>
                    <div class="my-2">
                        <input type="email" class="form-control"
                            id="email" name="email" placeholder="email" required />
                    </div>
                    <div>
                        <button type="submit" id="btnRegister" 
                            class="form-control btn btn-success disabled">회원가입</button>
                    </div>
                </form>
            </div>
        </main>
    </div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
	    crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="../js/user.js"></script>
</body>
</html>
