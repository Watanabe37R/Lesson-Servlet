package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.NumberGameBean;

/**
 * 数当てゲームのコントローラ(Servlet)
 * - doGet: ゲーム画面の初期表示、またはnewGameパラメータがあれば新規開始
 * - doPost: ユーザの入力を受け取り、Beanを更新してJSPへフォワード
 */
@WebServlet("/NumberGameServlet")
public class NumberGameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得
		HttpSession session = request.getSession();

		// newGameパラメータがある場合は新規ゲームを開始
		if (request.getParameter("newGame") != null) {
			//難易度
			String difficulty = request.getParameter("difficulty");
			NumberGameBean bean = new NumberGameBean(difficulty);
			session.setAttribute("numberGameBean", bean);
		} else {
			// まだBeanがない場合は新規作成
			NumberGameBean bean = (NumberGameBean) session.getAttribute("numberGameBean");
			if (bean == null) {
				bean = new NumberGameBean();
				session.setAttribute("numberGameBean", bean);
			}
		}

		// JSPへフォワード
		request.getRequestDispatcher("/view/numberGame.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得
		HttpSession session = request.getSession();
		NumberGameBean bean = (NumberGameBean) session.getAttribute("numberGameBean");

		// もしセッションにBeanがない場合は新規作成
		if (bean == null) {
			bean = new NumberGameBean();
			session.setAttribute("numberGameBean", bean);
		}

		// ユーザが入力したguessを取得
		String guessStr = request.getParameter("guess");
		if (guessStr != null && !guessStr.isEmpty()) {
			try {
				int guess = Integer.parseInt(guessStr);
				// Beanに判定させる
				bean.checkGuess(guess);
			} catch (NumberFormatException e) {
				// 整数以外が入力された場合の処理(今回は特に何もしない)
			}
		}

		// JSPへフォワード
		request.getRequestDispatcher("/view/numberGame.jsp").forward(request, response);
	}
}
