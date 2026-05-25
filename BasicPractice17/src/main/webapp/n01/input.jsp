<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="input" method="post">
		名前：<input tyoe="text" name="name" value="${sessionScope.name}">
		<input type="submit" value="送信">
	</form>
</body>
</html>