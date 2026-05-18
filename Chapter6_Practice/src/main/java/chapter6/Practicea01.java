package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Practicea01
 */
@WebServlet("/chapter6/practicea01")
public class Practicea01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] comment= request.getParameterValues("comment");
		response.setContentType("text/HTML;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Page.header(out);
		
		if(comment == null || comment.length < 0 || comment[0].isEmpty()) {
			out.println("<p>コメントがありませんでした。</p>");
		}else {
			out.println("<h1>あなたのコメント一覧</h1>");
			for(String c :comment) {
				out.println("<p>・"+c+"</p>");
			}
		}
		Page.footer(out);
	}

}
