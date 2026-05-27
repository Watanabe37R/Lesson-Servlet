<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="total" value="0" />
<c:forEach var="p" items="${list}">
    ${p.id}：${p.name}：${p.price}円<br>
	<c:set var="total" value="${total + p.price}" />
</c:forEach>
<p>合計金額：${total}円</p>
</body>
</html>