package chapter4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice02
 */
@WebServlet("/Practice02")
public class Practice02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		String lang = request.getHeader("Accept-Language");
		if (lang != null && lang.startsWith("ja")) {
			// 日本語
			response.getWriter().append("こんにちは！"); 
		} else if (lang != null && lang.startsWith("en")) {
			// 英語
			response.getWriter().append("Hello!");
		}

	}

}
