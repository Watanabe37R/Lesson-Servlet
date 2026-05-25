package n02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.Favorite;

/**
 * Servlet implementation class FavoriteServlet
 */
@WebServlet("/n02/favorites")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Favorite> list=(List<Favorite>)session.getAttribute("list");
		if(list==null) {
			 list =new ArrayList<>();
		}
		
		Favorite fav = new Favorite();
		
		fav.setName(request.getParameter("name"));
		fav.setUrl(request.getParameter("url"));
		list.add(fav);
		session.setAttribute("list", list);
		request.getRequestDispatcher("favorites.jsp").forward(request, response);
	}

}
