package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import beans.Question;
import beans.Response;
import dao.QuestionDAO;
import dao.ResponseDAO;

@WebServlet("/SurveyServlet")
public class SurveyServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 1-1: セッションを取得する
		HttpSession session = request.getSession();

		// TODO 1-2: セッションから"user_id"を取得する
		String userId = (String) session.getAttribute("user_id");

		// TODO 1-3: userIdがnullの場合、新しいIDを生成しセッションに保存する
		if (userId == null) {
			userId = "user" + System.currentTimeMillis();
			session.setAttribute("user_id", userId);
		}

		ResponseDAO daoR = new ResponseDAO();
		try {
			// TODO 1-4: 回答済みかどうかをチェックする
			if (daoR.hasAnswered(userId)) {
				// 回答済みの場合
				request.setAttribute("message", "回答を送信しました。");
			} else {
				// 未回答の場合は、questionDAOから質問を取得
				QuestionDAO daoQ = new QuestionDAO();
				List<Question> questions = daoQ.getAllQuestions();
				request.setAttribute("questions", questions);
				request.getRequestDispatcher("survey.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("survey.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 2-1: セッションを取得する
		HttpSession session = request.getSession();

		// TODO 2-2: セッションから"user_id"を取得する
		String userId = (String) session.getAttribute("user_id");

		// TODO 2-3: userIdがnullの場合、SurveyServletにリダイレクトする
		if (userId == null) {
			response.sendRedirect("SurveyServlet");
			return;
		}

		try {
			ResponseDAO daoR = new ResponseDAO();
			// TODO 2-4: フォームから送信された回答を取得する
			String[] answers = request.getParameterValues("answers");

			// TODO 2-5: 回答をデータベースに保存する
			for (int i = 0; i < answers.length; i++) {
				Response res = new Response();
				res.setUserId(userId);
				res.setQuestionId(i + 1);
				res.setAnswer(answers[i]);
				daoR.saveResponse(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO 2-6: セッションに"answered"をtrueで保存する
		session.setAttribute("answered", true);

		response.sendRedirect("SurveyServlet");
	}
}
