<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String username = request.getParameter("username");
	String ageStr = request.getParameter("age");

	// Nullチェックと""チェック
	if (username == null || username.isEmpty() || ageStr == null || ageStr.isEmpty()) {
		throw new Exception("未入力データがあります。");
	}

	// 年齢を整数に変換（例外の可能性あり）
	int age = Integer.parseInt(ageStr); // 数字以外なら例外発生
	%>

	<p>
		ユーザー名:
		<%=username%></p>
	<p>
		年齢:
		<%=age%></p>

</body>
</html>