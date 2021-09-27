<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
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
	font-size: 20px;
	text-align: center;
	border: 5px solid #ffd19f;
	border-radius: 20px;
}
</style>
</head>
<body>
	<h2>Today 글 수정/삭제</h2>
	<form action="today" method="POST">
		<input type="hidden" name="command" ; value="update">
		<table>
			<tr>
				<th>Title</th>
				<td><input class="span" type="text" name="tt"
					value="${requestScope.today.tt}" readonly></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><input class="span" type="date" name="dt"
					value="${requestScope.today.dt}"></td>
			</tr>
			<tr>
				<th>Write</th>
				<td><input class="span" type="textarea" name="wt"
					value="${requestScope.today.wt}"></td>
			</tr>
		</table>
		<input  class="span" type="submit" value="수정"> 
		<input class="span" type="button" value="삭제" onclick="location.href='today?command=delete&tt=${requestScope.today.tt}'">
		<button class="span" type = "button" onclick="javascript:history.back(1)">뒤로가기</button>
	</form>
</body>
</html>