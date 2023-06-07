package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection cn;// null
	// add a static method to return SINGLETON (=single instance in the entire Java
	// App) to the caller

	public static Connection openConnection() throws SQLException {
		if (cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/abhishek?useSSL=false&allowPublicKeyRetrieval=true";
				cn = DriverManager.getConnection(url, "root", "Abhi@2017");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
		return cn;
	}

	// add a static method to close connection.
	public static void closeConnection() throws SQLException {
		if (cn != null)
			cn.close();
	}

}
