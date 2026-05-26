package practice02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestScopeServlet
 */
@WebServlet("/RequestScopeServlet")
public class RequestScopeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ここに「message」という属性名で「Hello, Request Scope!」をリクエストスコープに設定するコードを追加
		request.setAttribute("message", "Hello, Request Scope!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/practice02/display.jsp");
		dispatcher.forward(request, response);
	}

}
