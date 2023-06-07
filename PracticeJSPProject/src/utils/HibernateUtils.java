package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory session;

	static {
		try {
			session = new Configuration().configure().buildSessionFactory();
			System.out.println("Session factory populated....");
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static SessionFactory getFactory() {
		return session;
	}

}
