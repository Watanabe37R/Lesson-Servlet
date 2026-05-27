package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Tweet;

@WebServlet("/tweet-delete")
public class DeleteCushionTweetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//コメントとユーザー名を取得
		int id = Integer.parseInt(request.getParameter("id"));
		String content=request.getParameter("content");
		String author=request.getParameter("author");
		Tweet tw = new Tweet();
		tw.setId(id);
		tw.setContent(content);
		tw.setAuthor(author);
		request.setAttribute("tw", tw);
		request.getRequestDispatcher("delete-cushion.jsp").forward(request, response);
	}
}
