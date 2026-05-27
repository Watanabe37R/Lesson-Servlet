<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ツイート一覧</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="container">
		<h1>ツイート一覧</h1>
		<!--エラーメッセージの表示-->
		<p>
			${requestScope.message}
		</p>
		
		<%-- 新規投稿 --%>
		<p>
			<a href="new_tweet.jsp">新規投稿</a>
		</p>

		<%-- ツイート一覧の表示 --%>
		<ul class="tweet-list">
			<!--<li>
				<div class="tweet-content">
					<p>content（ツイート内容）</p>
					<p class="tweet-info">投稿者: author - 投稿日時: posted_at</p>
				</div>
			</li> -->
			<!--forEachで回して、ツイート取得-->
			<c:forEach var="p" items="${tweets}">
				<li>
					<div class="tweet-content">
					<p>${p.content}</p>
					<p class="tweet-info">投稿者: ${p.author} - 投稿日時: ${p.postedAt}</p>
					<form action="tweet-delete" method="post">
						<input type="hidden" name="id" value="${p.id}">
						<input type="hidden" name="content" value="${p.content}">
						<input type="hidden" name="author" value="${p.author}">
						<input type="submit" value="削除">
					</form>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
