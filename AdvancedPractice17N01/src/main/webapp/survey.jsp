<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<title>アンケート</title>
</head>
<body>
	<h2>アンケート</h2>

	<c:if test="${not empty message}">
		<p>${message}</p>
	</c:if>

	<form action="SurveyServlet" method="post">
		<c:forEach var="question" items="${questions}" varStatus="status">
			<p>${question.text}</p>
			<input type="text" name="answers" required>
		</c:forEach>
		<br> <input type="submit" value="送信">
	</form>

	<a href="ResultsServlet">集計結果を見る</a>
</body>
</html>
