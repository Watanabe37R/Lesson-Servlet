<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="bean.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>データを並び替えました</p>
	<% for (Product p : (ArrayList<Product>) request.getAttribute("list")) { %>
	<%=p.getName()%>：<%=p.getPrice()%><br>
	<%}%>

</body>
</html>