package chapter10;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class practicea04
 */
@WebServlet("/chapter10/login")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        if (username != null && !username.isBlank() ) {
        	request.setAttribute("error", null);
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
            response.sendRedirect(request.getContextPath() + "/secure/index.jsp");
            return;
        }

        request.setAttribute("error", "ユーザー名を入力してください。");
        request.getRequestDispatcher("/chapter10/login.jsp").forward(request, response);
        
	}
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/chapter10/login.jsp")
	}*/

}
