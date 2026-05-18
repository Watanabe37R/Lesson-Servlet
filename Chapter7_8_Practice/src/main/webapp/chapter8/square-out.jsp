<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="square-error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
int num =Integer.parseInt(request.getParameter("number"));
%>
<p>入力した数値：<%=num %><br>結果：<%=num*num %></p>
</body>
</html>