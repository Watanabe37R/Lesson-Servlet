package chapter14;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ManageDB.OperationModel;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/chapter14/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String payment = request.getParameter("payment");
		String review = request.getParameter("review");
		boolean mail = request.getParameter("mail") != null;

		OperationModel.InsertDB(quantity, payment, review, mail);

		response.sendRedirect("registration.jsp");
	}

}
