package practice01.select;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Purchase;
import dao.PurchaseDAO;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/practice01.select/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Purchase p = new Purchase();
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setPayment(request.getParameter("payment"));
		p.setReview(request.getParameter("review"));
		p.setMail(request.getParameter("mail") != null);

		PurchaseDAO dao = new PurchaseDAO();
		try {
			int line = dao.InsertDB(p);
			if (line == 1) {
				response.sendRedirect(request.getContextPath() + "/practice01.select/result.jsp");
			} else {
				request.getRequestDispatcher("/practice01.select/errorresult.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
