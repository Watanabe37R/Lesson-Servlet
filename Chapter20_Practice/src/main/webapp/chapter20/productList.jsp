<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, dao.ProductDAO, bean.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="dao" class="dao.ProductDAO" />
	<%
	List<Product> list = new ArrayList<>();
	try{
		list = dao.findAll();
	}catch(Exception e){
		e.printStackTrace();
	}
	%>

	<table border="1">
		<tr>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格（円）</th>
		</tr>
		<%
		for (Product p : list) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>