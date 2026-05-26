package practice02;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServletP2
 */
public class MyServletP2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int timeout;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		String timeoutParam = getServletConfig().getInitParameter("timeout");
		if (timeoutParam == null) {
			System.err.println("timeout未設定");
			throw new ServletException("timeout未設定");
		}

		try {
			timeout = Integer.parseInt(timeoutParam);
		} catch (NumberFormatException e) {
			throw new ServletException("数値以外が入力されました", e);
		}

		System.out.println("timeout設定値: " + timeout);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().println("timeout = " + timeout);
		//取得した値を使って30秒後にforwardやsession timeoutなどつくれそう
	}
}
