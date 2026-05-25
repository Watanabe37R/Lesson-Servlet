package bean;

public class Customer {
	private int customerId;
	private String customerName;
	private String email;
	private String phoneNumber;

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer{customerId:" + customerId + " customerName:" + customerName + " email:" + email
				+ " phoneNumber:" + phoneNumber + "}";

	}
}
