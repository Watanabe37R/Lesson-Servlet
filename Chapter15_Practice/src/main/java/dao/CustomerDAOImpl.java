package dao;

import java.util.ArrayList;
import java.util.List;

import bean.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private List<Customer> customerList = new ArrayList<>();

	@Override
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}

	@Override
	public Customer getCustomer(int customerId) {
		for (Customer c : customerList) {
			if (c.getCustomerId() == customerId) {
				return c;
			}
		}
		return null;

	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerList;
	}

	@Override
	public void updateCustomer(Customer customer) {
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getCustomerId() == customer.getCustomerId()) {
				customerList.set(i, customer);
				return;
			}
		}

	}

	@Override
	public void deleteCustomer(int customerId) {
		customerList.removeIf(c -> c.getCustomerId() == customerId);
	}

	//Name検索
	public List<Customer> findByName(String name) {
		List<Customer> result = new ArrayList<>();

		for (Customer c : customerList) {
			if (c.getCustomerName().equals(name)) {
				result.add(c);
			}
		}
		return result;
	}

	//email検索
	public List<Customer> findByEmail(String email) {
		List<Customer> result = new ArrayList<>();

		for (Customer c : customerList) {
			if (c.getEmail().equals(email)) {
				result.add(c);
			}
		}
		return result;
	}
}
