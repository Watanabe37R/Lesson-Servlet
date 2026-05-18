package chapter6;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tool.Page;

/**
 * Servlet implementation class Practice01
 */
@WebServlet("/chapter6/practicea02")
public class Practicea02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String destination = request.getParameter("destination");
		String daysS = request.getParameter("days");
		String transport = request.getParameter("transport");
		String campaign = request.getParameter("campaign");

		//エラー用配列
		ArrayList<String> err = new ArrayList<>();

		//行き先EC
		if (destination.isBlank()) {
			err.add("行き先は必須です。");
		} else if (destination.length() > 50) {
			err.add("行き先は50文字以内で入力してください。");
		}

		//日数EC
		int days = -1;
		try {
			days = Integer.parseInt(daysS);
			if (days < 1 || days > 30) {
				err.add("日数は1～30の整数で入力してください。");
			}
		} catch (NumberFormatException e) {
			err.add("日数は数値で入力してください。");
		}

		//交通手段EC
		Set<String> allowed = Set.of("飛行機", "新幹線", "車");
		if (!allowed.contains(transport)) {
			err.add("交通手段が不正です。");
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//ページ表示
		Page.header(out);
		
		//エラーがある場合、表示
		if (!err.isEmpty()) {
			out.println("<h3>入力エラー</h3>");
			out.println("<ul>");
			for (String e : err) {
				out.printf("<li>%s</li>%n", e);
			}
			out.println("</ul>");
			Page.footer(out);
			return;
		}

		out.println("<p>「" + esc(destination) + "」への旅行を" + days + "日間、交通手段は「" + esc(transport) + "」で予約しました。</p>");
		if (campaign.equals("spring2025")) {
			out.println("<p>春のキャンペーンを適用しました。</p>");
		} else {
			out.println("<p>キャンペーンは適用されません。</p>");
		}

		Page.footer(out);
	}

	//null->""置換&エスケープ
	private static String esc(String s) {

		if (s == null) {
			return "";
		}

		return s.replace("&", "&amp;")
				.replace("<", "&lt;")
				.replace(">", "&gt;")
				.replace("\"", "&quot;")
				.replace("'", "&#x27;")
				.replace("/", "&#x2F;");
	}

}
