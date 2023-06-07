package pojo;

public class User {

	private int userId;
	private String name, email, date,role;
	private String regAmount;

	public User() {
		System.out.println("User Pojo instantiated");
	}

	public User(int userId, String name, String email, String date, String regAmount,String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.date = date;
		this.regAmount = regAmount;
		this.role=role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(String regAmount) {
		this.regAmount = regAmount;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", date=" + date + ", role=" + role
				+ ", regAmount=" + regAmount + "]";
	}

}
