package practice01.sort;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class SortServlet
 */
@WebServlet("/practice01.sort/sort")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PrintWriter out =response.getWriter();
		try {
			String order = request.getParameter("order");
			ProductDAO dao= new ProductDAO();
			ArrayList<Product> list = dao.sort(order);
			
			request.setAttribute("list", list);
			request.getRequestDispatcher("/practice01.sort/result.jsp").forward(request, response);

		}catch(Exception e) {
			e.printStackTrace();
		}


	}
}
