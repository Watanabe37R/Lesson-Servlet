package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import dao.ResponseDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ResultsServlet")
public class ResultsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ResponseDAO responseDAO = new ResponseDAO();

		// 質問ごとに回答を取得（Map<Question, List<Answer>>）
		Map<String, List<String>> responses = responseDAO.getAllResponses();

		// リクエストスコープにセット
		request.setAttribute("responses", responses);

		// results.jsp にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/results.jsp");
		dispatcher.forward(request, response);
	}
}
