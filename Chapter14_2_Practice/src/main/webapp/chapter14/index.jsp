<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="tool.Product"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css">
<meta charset="UTF-8">
<title>シンプル掲示板</title>
</head>
<body>
	<div class="container">
		<h1>掲示板</h1>
		<!-- 投稿フォーム -->
		<div class="post-form">
			<form action="/Chapter14_2_Practice/chapter14/index" method="post">
				<label for="name">名前:</label> <input type="text" name="name"
					id="name" required> <label for="content">本文:</label>
				<textarea name="content" id="content" rows="5" required></textarea>
				<input type="submit" value="投稿">
			</form>
		</div>

		<!-- 投稿一覧 -->

		<div class="posts">
			<%
			ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");

			for (Product p : list) {
			%>
			<div class="post">
				<p class="name"><%=p.getName()%></p>
				<p><%=p.getContent()%></p>
				<p class="date"><%=p.getPostDate()%></p>
			</div>
			<%
			}
			%>

		</div>
</body>
</html>