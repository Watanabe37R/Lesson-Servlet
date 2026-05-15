package chapter4;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice01
 */
@WebServlet("/Practice01")
public class Practice01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain; charset=UTF-8");

		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy年MM月dd日(E) HH時mm分ss秒", Locale.JAPAN);

		response.getWriter().append("現在の時刻は：" + LocalDateTime.now().format(date) + "です。");

	}

}
