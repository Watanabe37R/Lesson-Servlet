package tool;

import java.io.PrintWriter;

public class Page {

	public static void header(PrintWriter out) {
		out.println("""
				<%@ page language="java" contentType="text/html; charset=UTF-8"
				pageEncoding="UTF-8"%>
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
				</head>
				<body>
								""");
	}
	public static void footer(PrintWriter out) {
		out.println("""
				</body>
				</html>
				""");
	}
}
