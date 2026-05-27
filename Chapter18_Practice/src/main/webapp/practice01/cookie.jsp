<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String username = null;

	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user")) {
				username = cookie.getValue();
				break;
			}
		}
	}

	if (username != null) {
		out.println("<h1>ようこそ、" + username + "さん！</h1>");
	} else {
		out.println("<h1>ログインしてください</h1>");
	}
	%>

	<form action="cookie" method="post">
		<input type="text" name="username">
		<input type="submit" value="送信">
	</form>
	<a href="deletecookie" >クッキーを削除する</a>
</body>
</html>