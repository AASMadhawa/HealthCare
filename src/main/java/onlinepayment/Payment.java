package onlinepayment;


public class Payment {
	
	public int id;
	public String type;
	public int amount;
	public String date;
	public String description;
	public String email;
	
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", type=" + type + ", amount=" + amount + ", date=" + date + ", description="
				+ description + ", email=" + email + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

