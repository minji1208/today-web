<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘의 무너</title>
<style>
body {
	background-color: #ffecd2;
	color: black;
	margin-left: 40px;
	margin-right: 40px;
	position: relative;
	text-align: right;
	overflow-y: scroll;
}

header {
	background-color: #ffecd2;
	color: #2e2e2e;
	width: 100%;;
	heith: 5%;
	text-align: center;
}

div {
	text-align: center;
	margin-top: 50px;
}

form {
	text-align: center;
	margin-top: 50px;
}
table{
margin-left:auto;
margin-right:auto;
width:500px;
}

th {
border :2px solid #ffd19f;
height : 30px;
width : 100px;
}

td{
border : 2px solid #ffd19f;
height : 30px;
}
#div {
	display: block;
	margin-left: 20px;
	margin-right: 20px;
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
	<a style="text-align: right" href="title.jsp">로그아웃</a>
	<header>
		<img src="images/octo.jpg" width="70" height="70"><br>
		<h3>무너의 하루</h3>
	</header>
	<form action="today" method="POST">
		<button class="span" name="command" value="main">글쓰기</button><br><br><br>
		<table style="text-align:center">
			<tr>
				<th colspan="2">Title</th>
				<th>Date</th>
				<th colspan="2">Write</th>
			</tr>
			<c:choose>
				<c:when test="${empty requestScope.list || fn:length(list)==0}">
					<tr>
						<td colspan="4">
							<p>등록된 글 정보가 없습니다.</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.list}" var="m">
						<tr>
							<td colspan="2"><a href="today?command=read&tt=${m.tt}">${m.tt}</a></td>
							<td>${m.dt}</td>
							<td>${m.wt}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

	</form>

</body>
</html>