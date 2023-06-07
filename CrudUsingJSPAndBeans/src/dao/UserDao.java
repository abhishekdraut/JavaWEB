package dao;

import static utils.Conection.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.User;

public class UserDao {
	private Connection cn;
	private PreparedStatement ptst, getAllUserptst,deleteUserptst;
	

	public UserDao() throws SQLException {
		System.out.println("userDoa created");
		cn = getConnection();
		String getUser = "select * from users where email=? and password=?;";
		String getAllUser = "select * from users;";
		String deletUser="delete from users where userId=?;";
		ptst = cn.prepareStatement(getUser);
		getAllUserptst = cn.prepareStatement(getAllUser);
		deleteUserptst =cn.prepareStatement(deletUser);
		
		
	}

	public User validateUser(String email, String password) throws SQLException {

		ptst.setString(1, email);
		ptst.setString(2, password);
		ResultSet result = ptst.executeQuery();

		// piyush@gmail.com
		// pass@2014

		if (result.next()) {
			System.out.println("REtur object=======>");

			return new User((int) result.getObject("userId"), (String) result.getObject("name"),
					(String) result.getObject("email"), result.getObject("regDate").toString(),
					(String) result.getObject("regAmount"), (String) result.getObject("role"));

		} else {
			System.out.println("REtura askdnkalsn object=======>");
			return null;
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList getAllUsers() throws SQLException {

		ResultSet rs = getAllUserptst.executeQuery();
		ArrayList allUser=new ArrayList();
		while (rs.next()) {
			User temp = new User((int) rs.getObject("userId"), (String) rs.getObject("name"),
					(String) rs.getObject("email"), rs.getObject("regDate").toString(),
					(String) rs.getObject("regAmount"), (String) rs.getObject("role"));
			try {
				allUser.add(temp);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return allUser;
	}
	
	public String deleteUser(String id) {
		
		try {
			deleteUserptst.setString(1,id);
			int result=deleteUserptst.executeUpdate();
			System.out.println(result);
			if(result==1) {
				return "Ok";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
		
	}
	
}
