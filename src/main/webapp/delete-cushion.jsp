<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ツイート投稿</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="container">
		<h1>ツイート削除確認</h1>
		<hr>
		<div class="tweet-content">
			<p>${tw.content}</p>
			<p class="tweet-info">投稿者: ${tw.author}</p>
			<hr>
			<p>この投稿を削除しますか？</p>
			<hr>
			<form action="tweet-delete-complete" method="post">
				<input type="hidden" name="id" value="${tw.id}">
				<input type="submit" value="削除">
			</form>
			<hr>
			<form action="tweet_list" method="get">
				<input type="submit" value="戻る">
			</form>
			<hr>
		</div>
	</div>
</body>
</html>
