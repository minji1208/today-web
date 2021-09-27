<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 무너</title>
<script>
function joinCheck(){
	if(document.join.tt.value.trim()==""){
		alert('제목을 입력해주세요');
		document.join.tt.focuse();
		return false;
	}
	if(document.join.dt.value.trim()==""){
		alert('날짜를 입력해주세요');
		document.join.dt.focuse();
		return false;
	}
	if(document.join.wt.value.trim()==""){
		alert('내용을 입력해주세요.');
		document.join.dt.focuse();
		return false;
	}
	document.join.submit();
}
</script>
<style>
body {
   background-color: #ffecd2;
   color: black;
   margin-left: 40px;
   margin-right: 40px;
}

div {
   text-align: center;
   margin-top: 50px;
}

form {
   text-align: center;
   margin-top: 50px;
}

.span {
   background-color: #ffd19f;
   font-size: 20px;
   text-align: center;
   border: 8px solid #ffd19f;
   border-radius: 20px;
}
</style>
</head>
<body>
<div>
<h3>무너의 하루</h3>
<img src = "images/octo.jpg"><br><br>
</div>
<form action = "today" name="join" method="POST">
제목 : <input class="span" type="text" id="tt" name="tt"><br><br>
날짜 : <input class="span" type="date" id="dt" name="dt"><br><br>
오늘 무너는 <br><br>
<textarea class="span" type="text" name="wt" cols ="100" rows="30"
 placeholder="무슨 일이 있었나요?" id="wt"></textarea><br><br><br>
 
<input type="hidden" name="command" value="tinsert">
 <button class="span" type="button" onclick="joinCheck()">글 등록하기</button>
 <input class="span" type="reset" value="지우기">
 <button class="span" type = "button" onclick="location.href='today?command=list'">목록</button>
 </form>
</body>
</html>