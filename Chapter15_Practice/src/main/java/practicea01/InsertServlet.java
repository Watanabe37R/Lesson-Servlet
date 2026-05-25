package practicea01;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/practicea01/insert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp =new Employee();
		emp.setName(request.getParameter("name"));
		emp.setAge(Integer.parseInt(request.getParameter("age")));
		EmployeeDAO dao=new EmployeeDAO();
		try {
			if(dao.insert(emp)) {
				response.sendRedirect(request.getContextPath()+"/practicea01/insertConfirm.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/practicea01/employee");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
