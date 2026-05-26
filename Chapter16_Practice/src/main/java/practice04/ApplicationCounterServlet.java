package practice04;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicationCounterServlet
 */
@WebServlet("/ApplicationCounterServlet")
public class ApplicationCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//最初がnullの可能性を考慮し、定義,nullチェックしておく
		ServletContext context = getServletContext();
		Integer counter = (Integer) context.getAttribute("counter");
		
		//nullならカウンターを初期化
		if (counter == null) {
			counter = 1;
		} else {
			counter++;
		}
		
		context.setAttribute("counter", counter);

		//ここからそのまま
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>アプリ全体のアクセス数: " + counter + "</h1>");

	}

}
