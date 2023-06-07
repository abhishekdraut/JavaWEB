package beans;

import java.util.List;

import dao.UserDao;
import pojos.User;

public class UserBean {

	private String email;
	private String password;
	private UserDao userdao;
	private User userInfo;
	private List<User> users;
	private User selectedUser;
	
	//Form inputs
	
	private String formName;
	private String formEmail;
	private int formAmount;
	private String formDate;
	private String formRole;
	
	public UserBean() {
		System.out.println("User Bean Instantiated...........");
		userdao = new UserDao();

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
		
	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getFormEmail() {
		return formEmail;
	}

	public void setFormEmail(String formEmail) {
		this.formEmail = formEmail;
	}

	public int getFormAmount() {
		return formAmount;
	}

	public void setFormAmount(int formAmount) {
		this.formAmount = formAmount;
	}

	public String getFormDate() {
		return formDate;
	}

	public void setFormDate(String formDate) {
		this.formDate = formDate;
	}

	public String getFormRole() {
		return formRole;
	}

	public void setFormRole(String formRole) {
		this.formRole = formRole;
	}

	@Override
	public String toString() {
		return "UserBean [email=" + email + ", password=" + password + "]";
	}

	public String AuthenticateUser() {

		System.out.println("Email=>" + email + "pass==>" + password);
		User user = userdao.validateUser(email, password);
		if (user != null) {
			userInfo = user;
			return "home";
		}

		return "index";
	}

	public void GetAllUsers() {

		users = userdao.getAllUsers();
		if (users != null) {
			setUsers(users);
		}

	}
	public void GetUser(int id) {
		
		User theSelctedUser = userdao.getSelectedUser(id);
		if(theSelctedUser!=null ) {
			setSelectedUser(theSelctedUser);
		}
		
	}
	
	public String UpdateUser() {
		return userdao.updateUser(selectedUser.getUser_id(),getFormName(),getFormEmail(),getFormAmount(),getFormDate(),getFormRole());
	}

}
