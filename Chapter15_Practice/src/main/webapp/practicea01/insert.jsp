<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録フォーム</title>
</head>
<body>
<p>新規社員の登録を行います</p>
	
	<form action="insert" method="post" >
		<input type="hidden" name="action" value="insert">
		名前：<input type="text" name="name">
		年齢：<input type="text" name="age">
		<input type="submit" value="登録">
	</form>
</body>
</html>