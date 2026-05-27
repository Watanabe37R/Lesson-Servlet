<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<body>
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("themeColor".equals(cookie.getName())) {
		cookie.setMaxAge(0); // クッキーを削除
		response.addCookie(cookie);
			}
		}
	}
	%>
	<h2>テーマカラーがリセットされました</h2>
	<a href="home.jsp">ホームに戻る</a>
</body>
