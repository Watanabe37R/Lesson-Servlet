package chapter14;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ManageDB.OperationModel;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/chapter14/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		if(OperationModel.findOrder(name)) {
			OperationModel.UpdateDB(name, price);
			response.sendRedirect("complete.jsp");
		}else {
			request.getRequestDispatcher("notarget.jsp").forward(request, response);
		}
		
	}

}
