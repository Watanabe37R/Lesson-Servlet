<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:forward page="destination.jsp">
	<jsp:param name="username" value="taro" />
	<jsp:param name="role" value="admin" />
</jsp:forward>