package bean;

public class Purchase {
	private int id;
	private int quantity;
	private String payment;
	private String review;
	private boolean mail;

	public int getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getPayment() {
		return payment;
	}

	public String getReview() {
		return review;
	}

	public boolean getMail() {
		return mail;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setMail(boolean mail) {
		this.mail = mail;
	}
}
