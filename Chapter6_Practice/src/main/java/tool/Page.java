package tool;

import java.io.PrintWriter;

public class Page {
	public static void header(PrintWriter out) {
		System.out.println("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>結果</title>
				</head>
				<body>
								""");
	}

	public static void footer(PrintWriter out) {
		System.out.println("""
				</head>
				</html>
								""");
	}
}
