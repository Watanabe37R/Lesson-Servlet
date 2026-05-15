package chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Practice01
 */
@WebServlet("/chapter5/practice01")
public class Practice01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			request.setCharacterEncoding("UTF-8");
			
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			out.println("こんにちは"+name+"さん。"+ Process.AgeProcess(age)+"ですね。");
		}catch(NumberFormatException e) {
			out.println("年齢は数値を入力してください");
		}
		
		
	}

}
