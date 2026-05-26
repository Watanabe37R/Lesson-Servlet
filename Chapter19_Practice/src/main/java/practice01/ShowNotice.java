package practice01;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowNotice
 */
@WebServlet("/ShowNotice")
public class ShowNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String notice = (String) context.getAttribute("siteNotice");
		
		if (notice == null || notice.isEmpty()) {
			notice = "現在お知らせはありません。";
		}
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/practice01/showNotice.jsp").forward(request, response);
	}
}
