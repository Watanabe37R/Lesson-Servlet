<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--メインとなる問い合わせフォーム。
　　ここで取得したデータをやりくりします-->
<html>
<head>
<meta charset="UTF-8">
<title>問い合わせフォーム</title>
</head>
<body>
	<form action="/ServletTest/servlet/contact" method="post">
		<p>氏名*</p>
		<input type="text" name="name">
		<%
		if (session.getAttribute("nameerror") != null) {
		%>
		<p style="color: red;">
			<%=session.getAttribute("nameerror")%>
		</p>
		<%
		}
		%>
		<p>会社</p>
		<input type="text" name="company">
		<p>メールアドレス*</p>
		<input type="text" name="mailaddress">
		<%
		if (session.getAttribute("mailerror") != null) {
		%>
		<p style="color: red;">
			<%=session.getAttribute("mailerror")%>
		</p>
		<%
		}
		%>
		<p>お問い合わせ内容*</p>
		<textarea type="textarea" name="message" cols=30 rows=6></textarea>
		<%
		if (session.getAttribute("messageerror") != null) {
		%>
		<p style="color: red;">
			<%=session.getAttribute("messageerror")%>
		</p>
		<%
		}
		%>
		<p>メルマガ種類</p>
		<p>
			<input type="checkbox" name="mailmagazine" value="総合案内">総合案内
		</p>
		<p>
			<input type="checkbox" name="mailmagazine" value="セミナー案内">セミナー案内
		</p>
		<p>
			<input type="checkbox" name="mailmagazine" value="求人採用情報">求人採用情報
		</p>
		<p>資料請求希望</p>
		<p>
			<input type="radio" name="paper" value="Yes">Yes
		</p>
		<p>
			<input type="radio" name="paper" value="No">No
		</p>
				<%
		if (session.getAttribute("papererror") != null) {
		%>
		<p style="color: red;">
			<%=session.getAttribute("papererror")%>
		</p>
		<%
		}
		%>

		<input type="submit" value="送信">
	</form>
</body>
</html>