package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.TweetDAO;

@WebServlet("/tweet-delete-complete")
public class DeleteTweetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//コメントとユーザー名を取得
		int id = Integer.parseInt(request.getParameter("id"));
		TweetDAO tweetDAO = new TweetDAO();
		try {
			tweetDAO.deleteTweet(id);
			//成功なら何事もなくリダイレクト
			response.sendRedirect("tweet_list");
		} catch (Exception e) {
			e.printStackTrace();
			//エラー(例外)ならエラーを表示
			request.setAttribute("message", "エラーが発生し、ツイート削除ができませんでした。");
			request.getRequestDispatcher("/tweet_list").forward(request, response);
		}
		
		
	}
}
