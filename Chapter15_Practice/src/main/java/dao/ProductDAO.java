package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO extends DAO {
	public ArrayList<Product> sort(String order) throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		Connection con = getConnection();
		
		String sql;
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
		
		return list;
	}
}
