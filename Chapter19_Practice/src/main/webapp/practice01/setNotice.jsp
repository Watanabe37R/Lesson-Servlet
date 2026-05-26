<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>お知らせを設定</h1>

<c:if test="${not empty message}">
    <p style="color: green;">${message}</p>
</c:if>


	<form action="SetNotice" method="post">
		<input type="text" name="notice" required>
		<input type="submit" value="設定">
	</form>
	
	<c:if test="${not empty notice}">
		<h2>現在のお知らせ</h2>
		<p>${notice}</p>
	</c:if>
	
	<a href="ShowNotice">お知らせを確認</a>
</body>
</html>