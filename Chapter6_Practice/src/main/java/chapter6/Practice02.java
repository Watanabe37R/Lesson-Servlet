package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Practice02
 */
@WebServlet("/chapter6/practice02")
public class Practice02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String[] menu=request.getParameterValues("menu");	
		response.setContentType("text/HTML;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		Page.header(out);
		if(menu==null) {
			out.println("<p>サイドメニューなしでご提供します。</p>");
		}else {
			out.print("<p>追加サイドメニューは、");
			for(String m : menu) {
				out.print(m+" ");
			}
			out.println("です。</p>");
		}
		boolean found1 =Arrays.asList(menu).contains("サラダ");
		boolean found2 =Arrays.asList(menu).contains("スープ");
		if(found1&&found2) {
			out.println("<p>サラダ＆スープのセット割引が適用されました</p>");
			}
		Page.footer(out);
		
	}

}
