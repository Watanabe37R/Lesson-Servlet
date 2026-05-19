<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validate</title>
</head>
<body>

	<%
	// Servletに処理を渡す
	request.getRequestDispatcher("/chapter9/validate").forward(request, response);
	%>

</body>
</html>