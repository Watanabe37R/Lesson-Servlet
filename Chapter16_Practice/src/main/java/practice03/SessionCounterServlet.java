package practice03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionCounterServlet
 */
@WebServlet("/SessionCounterServlet")
public class SessionCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// セッションスコープで "counter" という属性を取得
		Integer counter = (Integer) session.getAttribute("counter");

		if (counter == null) {
			counter = 1;
		} else {
			// TODO: カウンターを1増やす
			counter++;
		}
		// TODO: セッションスコープにカウンターをセット
		session.setAttribute("counter", counter);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>現在のカウント: " + counter + "</h1>");
	}
}
