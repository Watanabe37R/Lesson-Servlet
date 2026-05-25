<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除フォーム</title>
</head>
<body>
<p>ID:${emp.id}　名前：${emp.name}　の削除を行います</p>
	
	<form action="delete" method="post" >
		<input type="hidden" name="action" value="delete">
		<input type="hidden" name="id" value="${emp.id}">
		<input type="submit" value="削除">
	</form>
</body>
</html>