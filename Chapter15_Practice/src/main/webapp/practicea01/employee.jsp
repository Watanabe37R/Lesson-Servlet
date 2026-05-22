<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>社員一覧</h1>
	<a href="" 
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
			<th>更新</th>
			<th>削除</th>
		</tr>
		<%
		for (Employee employee : (List<Employee>) request.getAttribute("list")) {
		%>
		<tr>
			<td><%=employee.getId()%></td>
			<td><%=employee.getName()%></td>
			<td><%=employee.getAge()%></td>
			<td><form action="employee" method="post" style="display: inline;">
					<input type="hidden" name="action" value="edit">
					<input type="hidden" name="id" value="<%=employee.getId()%>">
					<input type="submit" value="更新">
				</form></td>
			<td><form action="employee" method="post" style="display: inline;">
					<input type="hidden" name="action" value="delete">
					<input type="hidden" name="id" value="<%=employee.getId()%>">
					<input type="submit" value="削除">
				</form></td>
		</tr>
		<%
		}
		%>
	
</body>
</html>