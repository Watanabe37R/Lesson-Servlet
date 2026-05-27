<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="overprice" value="200" />
<h2>商品一覧（${overprice}円以上の商品）</h2>

<c:forEach var="p" items="${list}">
  <c:if test="${p.price >= overprice}">
    ID：${p.id}<br>
    商品名：${p.name}<br>
    価格：${p.price}円<br><br>
  </c:if>
</c:forEach>
</body>
</html>