package beans;

import pojo.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDao;

public class UserBean {

	private String email, password;
	private User user;
	private UserDao userdao;
	private boolean error;
	private ArrayList allUserData;

	public UserBean() throws SQLException {
		System.out.println("userBean Created .......");
		userdao = new UserDao();

	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setError(boolean val) {
		this.error = val;
	}

	public boolean getError() {
		return this.error;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList getAllUserData() {
		return allUserData;
	}

	public String validateUser() {

		try {
			System.out.println("validating For" + this.email + " & " + this.password);
			this.user = this.userdao.validateUser(this.email, this.password);
			if (user != null) {
				System.out.println("returnnin home");
				setError(false);
				return "home";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("returnnin validate");
		this.setError(true);
		return "Welcome";

	}

	public String fetchAllUser() {

		try {
			System.out.println("Fetching all the info from users........");
			this.allUserData = this.userdao.getAllUsers();
			System.out.println("This is date from bean" + allUserData.toString());
			return "Data loaded.";
		} catch (Exception e) {
			// TODO: handle exception

		}

		return null;
	}

	public String deleteUser(String id) {
		
		if(userdao.deleteUser(id)=="Ok") {
			return "Ok";
		};
		return null;
	}
}
