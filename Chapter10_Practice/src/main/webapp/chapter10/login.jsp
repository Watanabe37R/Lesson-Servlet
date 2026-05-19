<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>ログインしてください(簡易)</p>
	<form action="login" method="post">
		<input type="text" name="username">
		<input type="submit" value="ログイン">
	</form>

<%
if (request.getAttribute("error") != null) {
%>
<p style="color:red;">
    <%= request.getAttribute("error") %>
</p>
<%
}
%>

	
</body>
</html>