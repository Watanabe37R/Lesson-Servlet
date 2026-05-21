package ManageDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import tool.Product;

public class OperationModel {
	public static void InsertDB(String name, String content) {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con
					.prepareStatement("INSERT INTO posts(name, content) VALUES (?, ?)");

	        st.setString(1, name);
	        st.setString(2, content);
	        
	        st.executeUpdate();
	        
	        st.close();
	        con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Product> findAll() {
		ArrayList<Product> list = new ArrayList<>();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement("SELECT * FROM posts ORDER BY post_date DESC");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setContent(rs.getString("content"));
				p.setPostDate(rs.getTimestamp("post_date"));
				
				list.add(p);
			}
			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
