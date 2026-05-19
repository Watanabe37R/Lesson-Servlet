<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>ログインユーザー：<%= session.getAttribute("user") %>
<p>コンテンツ</p>
<a href="<%= request.getContextPath() %>/chapter10/logout">ログアウト</a>
</body>
</html>