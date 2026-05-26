<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, bean.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Product A001 = new Product();
	A001.setId(1);
	A001.setName("鉛筆");
	A001.setPrice(120);

	Product B002 = new Product();
	B002.setId(2);
	B002.setName("消しゴム");
	B002.setPrice(80);

	Map<String, Product> map = new HashMap<>(Map.of(
			"A001", A001, "B002", B002));
	request.setAttribute("map", map);
	%>
	<jsp:forward page="el1-display.jsp" />
</body>
</html>