package practicea02;

import bean.Customer;
import dao.CustomerDAO;
import dao.CustomerDAOImpl;

public class Main {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();

		// 追加
		Customer c1 = new Customer();
		c1.setCustomerId(1);
		c1.setCustomerName("田中");
		c1.setEmail("tanaka@example.com");
		c1.setPhoneNumber("090-1234-5678");

		dao.addCustomer(c1);

		// 取得
		Customer result = dao.getCustomer(1);
		System.out.println(result);

		// 全件
		for (Customer c : dao.getAllCustomers()) {
			System.out.println(c);
		}

		// 更新
		c1.setEmail("new@example.com");
		dao.updateCustomer(c1);
		
		// 取得(更新確認)
		result = dao.getCustomer(1);
		System.out.println(result);

		// 削除
		dao.deleteCustomer(1);
		
		// 取得(削除確認)
		result = dao.getCustomer(1);
		System.out.println(result);
	}
}
