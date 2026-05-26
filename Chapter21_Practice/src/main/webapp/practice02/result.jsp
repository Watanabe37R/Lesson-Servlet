<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${empty param.name ? "名前が未入力です" : "こんにちは、" += param.name += "さん"}
</body>
</html>