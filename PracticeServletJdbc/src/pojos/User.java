package pojos;

public class User {

	private int userId;
	private String name;
	private String email;
	private String date;
	private int salary;
	private String role;
	
	public User() {
		System.out.println("user Pojo created");
	}
	
	public User(int userId, String name, String email, String date, int salary, String role) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.date = date;
		this.salary = salary;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", date=" + date + ", salary="
				+ salary + ", role=" + role + "]";
	}
}
