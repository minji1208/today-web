<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용자 목록</title>
</head>
<body>
<form>
<table style="text-align:center">
			<tr>
				<th>id</th>
				<th>password</th>
				<th>nickname</th>
			</tr>
			<c:choose>
				<c:when test="${empty requestScope.ulist || fn:length(ulist)==0}">
					<tr>
						<td colspan="4">
							<p>등록된 유저 정보가 없습니다.</p>
						</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.ulist}" var="u">
						<tr>
							<td>${u.id}</td>
							<td>${u.pwd}</td>
							<td>${u.nick}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<button type = "button" onclick="javascript:history.back(1)">뒤로가기</button>
</form>
</body>
</html>