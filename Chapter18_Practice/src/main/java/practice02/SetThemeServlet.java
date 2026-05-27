package practice02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetThemeServlet
 */
@WebServlet("/practice02/SetThemeServlet")
public class SetThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: ユーザーが選択したテーマカラーを取得
		String themeColor = request.getParameter("themeColor");
		
        //TODO: クッキーに保存（有効期限30日）
		Cookie themeCookie = new Cookie("themeColor", themeColor);
        themeCookie.setMaxAge(60 * 60 * 24 * 30); // 30日間有効
        response.addCookie(themeCookie);
        
        //TODO: home.jsp にリダイレクト
        response.sendRedirect("home.jsp");
	}

}
