package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import beans.Response;

public class ResponseDAO extends DAO {

	public void saveResponse(Response response) throws Exception {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("INSERT INTO responses (user_id, question_id, answer) VALUES (?, ?, ?)")) {

			stmt.setString(1, response.getUserId());
			stmt.setInt(2, response.getQuestionId());
			stmt.setString(3, response.getAnswer());
			stmt.executeUpdate();
		}
	}

	public boolean hasAnswered(String userId) throws Exception {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM responses WHERE user_id = ?")) {

			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) > 0;
			}
		}
		return false;
	}

	public Map<String, List<String>> getAllResponses() {
		Map<String, List<String>> responses = new LinkedHashMap<>();

		String sql = "SELECT q.question_text, r.answer " +
				"FROM questions q " +
				"LEFT JOIN responses r ON q.id = r.question_id " +
				"ORDER BY q.id, r.id";

		try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {
				String question = rs.getString("question_text");
				String answer = rs.getString("answer");

				// 質問が Map にない場合、新しいリストを作成
				responses.putIfAbsent(question, new ArrayList<>());

				// 回答がある場合のみリストに追加
				if (answer != null) {
					responses.get(question).add(answer);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responses;
	}
}
