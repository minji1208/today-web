<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to MoonerLand</title>
<style>
body {
   background-color: #ffecd2;
   color: black;
   margin-left: 40px;
   margin-right: 40px;
}

div {
   text-align: center;
   margin-top: 180px;
}

form {
   text-align: center;
   margin-top: 30px;
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
      <img src= "images/smocto.png" width = "300" height = "300">
</div>
<div>
<form>
   무너의 하루에 오신 것을 환영합니다!<br/><br/>
   <button class = "span" type = "button" onclick="location.href='title.jsp'">무너와 함께하러 가기</button>
</form>
</div>
   
</body>
</html>