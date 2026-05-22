package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import bean.Purchase;

public class PurchaseDAO extends DAO {
	public int InsertDB(Purchase p) throws Exception {

		Connection con = getConnection();

		PreparedStatement st = con
				.prepareStatement("INSERT INTO purchase(quantity, payment, review, mail) VALUES (?, ?, ?, ?)");

		st.setInt(1, p.getQuantity());
		st.setString(2, p.getPayment());
		st.setString(3, p.getReview());
		st.setBoolean(4, p.getMail());

		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
