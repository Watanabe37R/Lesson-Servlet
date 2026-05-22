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
		int id = Integer.parseInt(request.getParameter("id"));
		if ("edit".equals(action)) {
			//更新画面へ
			request.setAttribute("id",id); 
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}else if("update".equals(action)) {
			//更新実行
			
			response.sendRedirect(request.getContextPath()+"/practicea01/employee");
		} else if ("delete".equals(action)) {
			//削除画面へ
			request.setAttribute("id",id); 
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}else if("deleteConfirm".equals(action)){
			//削除実行
			
			response.sendRedirect(request.getContextPath()+"/practicea01/employee");
		}

	}

}
