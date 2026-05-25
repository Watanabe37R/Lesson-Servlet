package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Question;

public class QuestionDAO extends DAO {
    
    public List<Question> getAllQuestions() throws Exception {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM questions");
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setText(rs.getString("question_text"));
                questions.add(question);
            }
        }
        return questions;
    }
}
