<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ page import="bean.NumberGameBean"%>
<%@ page import="bean.GuessResult"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数当てゲーム</title>
</head>
<body>
	<h1>数当てゲーム!</h1>

	<!-- 新しいゲーム(難易度設定あり)を始めるリンク -->
	<p>難易度を選んでね<br>
	<form action="${pageContext.request.contextPath}/NumberGameServlet"
		method="get">
		<button type="submit" name="difficulty" value="easy">EASY</button>
		<button type="submit" name="difficulty" value="normal">NORMAL</button>
		<button type="submit" name="difficulty" value="hard">HARD</button>
		<input type="hidden" name="newGame" value="true">
	</form>
	</p>

	<c:choose>
		<c:when test="${empty numberGameBean.number}">
			<p>上のボタンから難易度を選択してください</p>
			<!-- 入力フォームを出さない -->
		</c:when>
		<c:otherwise>
			<p>1-${numberGameBean.number}の数字を当ててね</p>
			<!-- 入力フォーム -->
			<form action="${pageContext.request.contextPath}/NumberGameServlet"
				method="post">
				<input type="text" name="guess" /> <input type="submit" value="送信" />
			</form>
		</c:otherwise>
	</c:choose>



	<!-- 履歴表示 -->
	<table border="1">
		<tr>
			<th>No.</th>
			<th>入力値</th>
			<th>結果</th>
		</tr>
		<c:forEach var="gr" items="${numberGameBean.guessHistory}"
			varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${gr.guess}</td>
				<td>${gr.message}</td>
			</tr>
		</c:forEach>
	</table>

	<!-- 当たりの場合は正解を表示 -->
	<c:if test="${numberGameBean.finished}">
		<p style="color: blue; font-weight: bold;">正解は
			${numberGameBean.answer} でした！</p>
	</c:if>


</body>
</html>
