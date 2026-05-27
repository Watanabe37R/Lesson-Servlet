<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=""UTF-8"">
<title>テーマカラー設定</title>
</head>
<body>
	<h2>テーマカラーを選択してください</h2>
	<form action="SetThemeServlet" method="post">
		<label><input type="radio" name="themeColor"value="lightblue">水色</label><br> 
		<label><input type="radio" name="themeColor"value="lightgreen">ライトグリーン</label><br> 
		<label><input type="radio" name="themeColor"value="lightpink">ピンク</label><br> 
		<label><input type="radio" name="themeColor"value="white" checked>白（デフォルト）</label><br>
		<br>
		<input type="submit" value="保存">
	</form>
	<a href="home.jsp">ホームに戻る</a>
</body>
</html>	