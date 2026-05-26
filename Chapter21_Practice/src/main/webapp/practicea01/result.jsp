<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import="bean.User"%>
	<%
	User user = new User("user");//""or"admin"or任意の名前 
	request.setAttribute("user", user);
	%>
	<p>${empty user.name ? "ユーザー名が未設定です" : (user.name == "admin" ? "管理者としてログイン中" : "こんにちは、" += user.name += "さん")}</p>
</body>
</html>