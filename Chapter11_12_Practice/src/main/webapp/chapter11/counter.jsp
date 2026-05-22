<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Counter: ${counter}
<form action="counter" method="get">
    <button type="submit" name="action" value="increment">+1</button>
    <button type="submit" name="action" value="reset">Reset</button>
    <button type="submit" name="action" value="decrement">-1</button>
</form>

</body>
</html>