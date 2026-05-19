package chapter9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practicea04
 */
@WebServlet("/chapter9/validate")
public class Practicea04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String uName=request.getParameter("username");
		try{
			LoginCheck.NullCheck(uName);
		}catch(Exception e) {
			request.getRequestDispatcher("/chapter9/error.jsp").forward(request, response);
		}
		if(uName.equals("admin")){
			response.sendRedirect("/Chapter9_Practice/chapter9/admin.jsp");
		}else {
			request.getRequestDispatcher("/chapter9/home.jsp").forward(request, response);
		}
	}

}
