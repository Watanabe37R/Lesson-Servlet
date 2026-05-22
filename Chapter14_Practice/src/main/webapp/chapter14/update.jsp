<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>修正する商品を入力してください</p>
	<form action="update" method="post">
		商品名<input type="text" name="name">
		価格<input type="text" name="price">
		<input type="submit" value="更新">
	</form>
</body>
</html>