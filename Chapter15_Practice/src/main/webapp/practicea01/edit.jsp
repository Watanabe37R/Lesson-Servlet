<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新フォーム</title>
</head>
<body>
<p>ID:${emp.id}　名前：${emp.name}　の修正を行います</p>
	
	<form action="edit" method="post" >
		<input type="hidden" name="action" value="edit">
		<input type="hidden" name="id" value="${emp.id}">
		名前：<input type="text" name="name">
		年齢：<input type="text" name="age">
		<input type="submit" value="更新">
	</form>
</body>
</html>