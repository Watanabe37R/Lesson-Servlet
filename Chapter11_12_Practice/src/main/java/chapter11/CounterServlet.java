package chapter11;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CounterServlet
 */
@WebServlet("/chapter11/counter")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtomicInteger counter;

	@Override
	public void init() throws ServletException {
		System.out.println("Counter initialized : set to 0");
		counter = new AtomicInteger(0);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("increment".equals(action)) {
			counter.incrementAndGet();
		} else if ("reset".equals(action)) {
			counter.set(0);
		}else if("decrement".equals(action)) {
			counter.decrementAndGet();
		}

		request.setAttribute("counter", counter.get());
		request.getRequestDispatcher("/chapter11/counter.jsp").forward(request, response);

	}

	@Override
	public void destroy() {
		System.out.println("Counter Final : get to " + counter.get());
	}
}
