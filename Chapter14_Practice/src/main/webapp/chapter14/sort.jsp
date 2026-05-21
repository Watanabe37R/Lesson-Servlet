<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>価格順に並び変えます</p>
	<form action="sort" method="post">
		<select name="order">
			<option value="ASC">低い順</option>
			<option value="DESC">高い順</option>
		</select>
		<input type="submit" value="実行">
	</form>
</body>
</html>