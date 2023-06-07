package dao;

import static Utils.DbUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pojos.User;

public class UserDao {
	private Connection cn;
	private String stmtGetAll, stmtGetUser;

	public UserDao() throws SQLException {
		System.out.println("User dao defalt....");
		cn = openConnection();
		stmtGetAll = "select * from users;";
		stmtGetUser = "select * from users where email=? and password=?;";

	}

	public ArrayList<User> getAllUsers() throws SQLException {

		PreparedStatement stmt = cn.prepareStatement(stmtGetAll);
		ArrayList<User> users = new ArrayList();
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
					result.getInt(5), result.getString(6)));
		}
		return users;

	}

	public User authenticateUser(String email, String password) throws SQLException {

		PreparedStatement stmt = cn.prepareStatement(stmtGetUser);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet result = stmt.executeQuery();

		if (result.next()) {
			result.toString();
			return new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
					result.getInt(5), result.getString(6));

		} else {
			System.out.println("null reuslt in dao");
			return null;
		}

	}

}
