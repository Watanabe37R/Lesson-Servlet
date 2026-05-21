package chapter14;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ManageDB.OperationModel;
import tool.Product;

/**
 * Servlet implementation class SortServlet
 */
@WebServlet("/chapter14/sort")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out =response.getWriter();
		String order = request.getParameter("order");
		ArrayList<Product> list = OperationModel.sortAll(order);

		request.setAttribute("list", list);
		request.getRequestDispatcher("/chapter14/result.jsp").forward(request, response);
	}

}
