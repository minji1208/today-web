<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>무너문어 시작하기</title>
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
	if(document.join.nick.value.trim()==""){
		alert('닉네임을 입력해주세요');
		document.join.nick.focus();
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
<h3>새로운 무너 등록하기</h3>
<img src = "images/octo.jpg"><br>
</div>
<form action="today" name="join" method="POST">
<input type="hidden" name="command" value="insert">
아이디 : <input class="span" type="text" id="id" name="id"><br>
비밀번호 : <input class="span" type="password" id="pwd" name="pwd"><br>
닉네임 : <input class="span" type="text" id="nick" name="nick"><br><br>

<button class="span" type="button" onclick="joinCheck()">등록</button>
<button class="span" type="button" onclick="javascript:history.back(1)">취소</button>
</form>
</body>
</html>