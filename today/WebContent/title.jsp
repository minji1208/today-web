<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무너의 하루</title>
<style>
body {
	background-color: #ffecd2;
	color: #2e2e2e;
	margin-left: 40px;
	margin-right: 40px;
}

div {
	text-align: center;
	margin-top: 180px;
}

form {
	text-align: center;
	margin-top: 50px;
}

.span {
	background-color: #ffd19f;
	font-size: 25px;
	text-align: center;
	border: 8px solid #ffd19f;
	border-radius: 20px;
}
</style>
</head>
<body>
<div>
		<img src="images/octo.jpg"><br> <br>
	</div>
	<form>
		<button class="span" type="button" onclick="location.href='login.jsp'">로그인</button> <br> <br> <br> 
		<button class="span" type="button" onclick="location.href='insert.jsp'">회원가입</button>
	</form>
</body>
</html>