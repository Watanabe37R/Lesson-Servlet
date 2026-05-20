package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import models.NullCheck;

/**
 * コンタクトで使用するサーブレット。
 * Nullの場合と正常な場合で区別して次を表示。
 */
@WebServlet("/servlet/contact")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String company=request.getParameter("company");
		String mailaddress=request.getParameter("mailaddress");
		String message=request.getParameter("message");
		String[] mailmagazine=request.getParameterValues("mailmagazine");
		String paper=request.getParameter("paper");
		System.out.println(name+" "+company+" "+mailaddress+" "+message+" "+paper);
		
		HttpSession session = request.getSession(true);
		//nullの場合
		int flug=0;
		if(NullCheck.isNull(name)){
			//request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			session.setAttribute("nameerror", "名前が入力されていません");
			flug++;
		}

		if(NullCheck.isNull(mailaddress)){
			//request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			session.setAttribute("mailerror", "メールアドレスが入力されていません");
			flug++;
		}
		if(NullCheck.isNull(message)){
			//request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			session.setAttribute("messageerror", "お問い合わせ内容が入力されていません");
			flug++;
		}
		if(NullCheck.isNull(paper)){
			//request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			session.setAttribute("papererror", "お問い合わせ内容が入力されていません");
			flug++;
		}
		if (flug>0) {
			flug=0;
			request.getRequestDispatcher("/jsp/contact.jsp").forward(request, response);
		}
		
        session.setAttribute("name", name);
        session.setAttribute("company", company);
        session.setAttribute("mailaddress", mailaddress);
        session.setAttribute("message", message);
        session.setAttribute("paper", paper);
        for(int i=0;i<mailmagazine.length;i++) {
        	session.setAttribute("mailmagazine"+i, mailmagazine[i]);
        }
        //送信を伴うので、リダイレクトで対応
		//request.getRequestDispatcher("/complete").forward(request, response);
        response.sendRedirect("/ServletTest/complete");
	}

}
