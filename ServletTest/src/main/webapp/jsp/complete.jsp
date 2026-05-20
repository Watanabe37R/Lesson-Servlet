<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--本来ならJSPで完了画面を出したかったが、
　　JSPでlistの中身を書く技量がなかったため断念-->
<html>
<head>
<meta charset="UTF-8">
<title>送信完了</title>
</head>
<body>
<%-- 	<h1>お問い合わせありがとうございます。</h1>
	<p>氏名</p>
	<%=request.getParameter("name") %>
	<p>会社</p>
	<%=request.getParameter("company") %>
	<p>メールアドレス</p>
	<%=request.getParameter("mailaddress") %>
	<p>お問い合わせ内容</p>
	<%=request.getParameter("message") %>
	<p>メルマガ種類</p>
	<%
	Papers.PaperList(request, response);
	%>
	<p>資料請求希望</p>
	<%=request.getParameter("paper") %> --%>
</body>
</html>