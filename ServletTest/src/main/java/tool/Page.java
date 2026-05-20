package tool;

import java.io.PrintWriter;
/*
 * サーブレットでHTMLを出力させるために必要な
 * ヘッダーとフッダーを定義。Page.～で使用可。
 */
public class Page {

	public static void header(PrintWriter out) {
		out.println("<DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>送信完了</title>");
		out.println("</head>");
		out.println("<body>");
	}
	
	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");
	}
}
