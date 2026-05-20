package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import tool.Page;

/**
 * 完了画面を出すためのサーブレット
 * 本来であればJSPで書くべきだが、
 * JSPの書き方がわからずサーブレットで実施。
 */
@WebServlet("/complete")
public class CompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				HttpSession session = request.getSession(true);
				PrintWriter out = response.getWriter();
				Page.header(out);
				out.println("""
						<h1>お問い合わせありがとうございます。</h1>
						<p>氏名</p>
						""");
				out.println("・" + session.getAttribute("name"));
				out.println("<p>会社</p>");
				out.println("・" + session.getAttribute("company"));
				out.println("<p>メールアドレス</p>");
				out.println("・" + session.getAttribute("mailaddress"));
				out.println("<p>お問い合わせ内容</p>");
				out.println("・" + session.getAttribute("message"));
				out.println("<p>メルマガ種類</p>");
		        for(int i=0;i<3;i++) {
		        	if(session.getAttribute("mailmagazine"+i)!=null) {
		        		out.println("・" + session.getAttribute("mailmagazine"+i));
		        	}
		        }
				out.println("<p>資料請求希望</p>");
				out.println("・" + session.getAttribute("paper"));
				if (session.getAttribute("paper").equals("Yes")) {
					out.println("<p>この度は資料請求いただきありがとうございます。<br>資料は以下リンクからダウンロード可能です。</p>");
					out.println("<input type=\"submit\" value=\"ダウンロード\">");
				}
				Page.footer(out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*		PrintWriter out = response.getWriter();
				Page.header(out);
				out.println("""
						<h1>お問い合わせありがとうございます。</h1>
						<p>氏名</p>
						""");
				out.println("・" + request.getParameter("name"));
				out.println("<p>会社</p>");
				out.println("・" + request.getParameter("company"));
				out.println("<p>メールアドレス</p>");
				out.println("・" + request.getParameter("mailaddress"));
				out.println("<p>お問い合わせ内容</p>");
				out.println("・" + request.getParameter("message"));
				out.println("<p>メルマガ種類</p>");
				for (String item : request.getParameterValues("mailmagazine")) {
					out.print("・" + item);
				}
				out.println("<p>資料請求希望</p>");
				out.println("・" + request.getParameter("paper"));
				if (request.getParameter("paper").equals("Yes")) {
					out.println("<p>この度は資料請求いただきありがとうございます。<br>資料は以下リンクからダウンロード可能です。</p>");
					out.println("<input type=\"submit\" value=\"ダウンロード\">");
				}
				Page.footer(out);*/
	}
}
