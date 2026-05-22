package ManageDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import tool.Product;

public class OperationModel {
	public static void InsertDB(int quantity, String payment, String review, boolean mail) {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con
					.prepareStatement("INSERT INTO purchase(quantity, payment, review, mail) VALUES (?, ?, ?, ?)");

			st.setInt(1, quantity);
			st.setString(2, payment);
			st.setString(3, review);
			st.setBoolean(4, mail);

			st.executeUpdate();

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Product> sortAll(String order) {
		ArrayList<Product> list = new ArrayList<>();
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			String sql = "";

			if ("ASC".equals(order)) {
				sql = "SELECT * FROM product ORDER BY price ASC,name ASC";
			} else {
				sql = "SELECT * FROM product ORDER BY price DESC,name ASC";
			}

			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));

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

	public static boolean findOrder(String order) {
		//ArrayList<Product> list = new ArrayList<>();
		boolean existence = false;
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE name = ?");
			st.setString(1, order);
			ResultSet rs = st.executeQuery();

			existence = rs.next();

			rs.close();
			st.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existence;
	}

	public static void UpdateDB(String name, int price) {
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
			Connection con = ds.getConnection();

			PreparedStatement st = con.prepareStatement("UPDATE product SET price = ? WHERE name = ?");

			st.setInt(1, price);
			st.setString(2, name);

			st.executeUpdate();

			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
