<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.ArrayList" %>
<%@ page import="tool.Product" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>データを並び替えました</p>
	<%
	ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("list");
	for (Product p : list) {
	%>
	<%=p.getName()%>
	:
	<%=p.getPrice()%><br>
	<%
	}
	%>

</body>
</html>