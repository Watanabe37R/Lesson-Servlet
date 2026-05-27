<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- userNameをセッション属性にセット -->
<c:set var="userName" value="" scope="session"/>


<!-- userNameが存在するかどうかで分岐 -->
<!-- 処理を書く -->
<c:choose>
    <c:when test="${not empty userName}">
        ようこそ、${userName}さん！
    </c:when>
    <c:otherwise>
        ログインしてください。
    </c:otherwise>
</c:choose>


</body>
</html>
