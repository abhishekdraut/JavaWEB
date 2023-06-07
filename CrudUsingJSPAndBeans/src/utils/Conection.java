package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conection {

	private static Connection connection;

	public static Connection getConnection() {

		if (connection == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/abhishek?useSSL=false&allowPublicKeyRetrieval=true","root","Abhi@2017");
				System.out.println("Conenction Eastablished");
				return connection;
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
			}

		}
		return connection;
	}

}
