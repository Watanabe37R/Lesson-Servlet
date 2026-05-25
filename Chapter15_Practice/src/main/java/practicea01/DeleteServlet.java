package practicea01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/practicea01/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		EmployeeDAO dao=new EmployeeDAO();
		try {
			if(dao.delete(id)) {
				response.sendRedirect(request.getContextPath()+"/practicea01/deleteConfirm.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/practicea01/employee");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
