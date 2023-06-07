package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {

	private static Connection connection;
	
	public static Connection openConnection() {

		try {

			if (connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/abhishek", "root", "Abhi@2017");
				System.out.println("Connection Eastblished");
				return connection;
			}

		} catch (Exception e) {

			System.out.println("Error while connecting @ DbUtils.." + e);

		}

		return connection;

	}

}
