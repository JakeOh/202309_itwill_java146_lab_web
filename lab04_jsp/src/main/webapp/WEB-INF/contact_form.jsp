<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP 1</title>
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
            rel="stylesheet" 
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" 
            crossorigin="anonymous">
	</head>
	<body>
		<h1>연락처 입력 페이지</h1>
        
        <div class="card m-2">
            <form action="mvc" method="post">
                <div class="m-2">
                    <input type="number" class="form-control" 
                        name="id" placeholder="아이디" autofocus required />
                </div>
                <div class="m-2">
                    <input type="text" class="form-control" 
                        name="name" placeholder="이름" required />
                </div>
                <div class="m-2">
                    <input type="text"  class="form-control" 
                        name="phone" placeholder="전화번호" required />
                </div>
                <div class="m-2">
                    <input type="email" class="form-control" 
                        name="email" placeholder="이메일" />
                </div>
                <div class="m-2">
                    <input type="reset" class="btn btn-secondary" value="취소" />
                    <input type="submit" class="btn btn-primary" value="저장" />
                </div>
            </form>
        </div>
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
    	    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" 
    	    crossorigin="anonymous"></script>
	</body>
</html>
