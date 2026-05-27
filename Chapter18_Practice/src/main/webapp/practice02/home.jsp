<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホーム</title>
<%
//TODO: クッキーからテーマカラーを取得（デフォルトは白）
String themeColor = "white";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie cookie : cookies) {
		if ("themeColor".equals(cookie.getName())) {
	themeColor = cookie.getValue();
	break;
		}
	}
}
%>
<style>
body {
	background-color: <%=themeColor%>;
}
</style>
</head>
<body>
	<h1>ようこそ！</h1>
	<p>
		現在のテーマカラー:
		<%=themeColor%></p>
	<a href="settings.jsp">テーマカラーを変更</a>
	<br>
	<a href="reset.jsp">設定をリセット</a>
</body>
</html>