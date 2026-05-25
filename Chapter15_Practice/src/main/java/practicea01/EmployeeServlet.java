package practicea01;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Employee;
import dao.EmployeeDAO;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/practicea01/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeDAO dao = new EmployeeDAO();
		try {
			List<Employee> list = dao.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/practicea01/employee.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		Employee emp =new Employee();
		
		if ("edit".equals(action)) {
			//更新画面へ
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setName(request.getParameter("name"));
			request.setAttribute("emp",emp); 
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		} else if ("delete".equals(action)) {
			//削除画面へ
			emp.setId(Integer.parseInt(request.getParameter("id")));
			emp.setName(request.getParameter("name"));
			request.setAttribute("emp",emp); 
			
			request.getRequestDispatcher("delete.jsp").forward(request, response);
		}else if("insert".equals(action)){
			//登録画面へ
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}

	}

}
