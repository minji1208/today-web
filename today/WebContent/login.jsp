<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무너와 함께하기</title>
<script>
function joinCheck(){
	if(document.join.id.value.trim()==""){
		alert('아이디를 입력해주세요.');
		document.join.id.focus();
		return false;
	}
	if(document.join.pwd.value.trim()==""){
		alert('비밀번호를 입력해주세요');
		document.join.pwd.focus();
		return false;
	}
	document.join.submit();
}
</script>
<style>
body {
	background-color: #ffecd2;
	color: #2e2e2e;
	margin-left: 40px;
	margin-right: 40px;
}
input{
background-color : #ffd19f;
color:#2e2e2e;
border : 3px solid #ffd19f; 
}
div {
	text-align: center;
	margin-top: 80px;
}

form {
	text-align: center;
	margin-top: 50px;
}

.span {
	background-color: #ffd19f;
	font-size: 18px;
	text-align: center;
	border: 8px solid #ffd19f;
	border-radius: 20px;
}
</style>
</head>
<body>
	<div>
	<h3>무너와 함께하기</h3>
		<img src="images/octo.jpg"><br> <br>
	</div>
	<form action="today" name="join" method="POST">
	<input type="hidden" name="command" value="login">
		아이디 : <input class="span" type="text" name="id">
		<br> 비밀번호 : <input class="span" type="password" name="pwd"><br>
		<br> <input class="span" type="submit" onclick="joinCheck();" value="로그인">
		<button class="span" type = "button" onclick="javascript:history.back(1)">뒤로가기</button>
	</form>
</body>
</html>