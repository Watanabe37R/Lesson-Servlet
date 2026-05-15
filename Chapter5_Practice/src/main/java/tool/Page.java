package tool;

import java.io.PrintWriter;

public class Page {

	public static void header(PrintWriter out) {
		out.println("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="UTF-8">
				<title>背景色を変えるフォーム</title>
				</head>
				""");
	}
	public static void footer(PrintWriter out) {
		out.println("""
				</body>
				</html>
				""");
	}
}
