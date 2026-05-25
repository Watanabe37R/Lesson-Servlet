package dao;

import java.util.List;

import bean.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer);
	Customer getCustomer(int customerId);
	List<Customer> getAllCustomers();
	void updateCustomer(Customer customer);
	void deleteCustomer(int customerId);
}
