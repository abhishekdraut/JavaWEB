package dao;

import static utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import pojos.User;

public class UserDao {
	private SessionFactory sf;

	public UserDao() {
		System.out.println("userDao instantiated.......");
		sf = getFactory();
	}

	public User validateUser(String email, String password) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			User theUser = session
					.createQuery("select u from User u where u.email=:email and u.password=:password", User.class)
					.setParameter("email", email).setParameter("password", password).getSingleResult();
//			List <User> user=theUserQuery.getResultList();
			System.out.println("Result List========>" + theUser.equals(null));
			tx.commit();
			return theUser;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			tx.rollback();
		}
		return null;
	}

	public List<User> getAllUsers() {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			List<User> theUser = session.createQuery("select u from User u", User.class).getResultList();
			tx.commit();
			return theUser;

		} catch (Exception e) {
			tx.rollback();
			System.out.println("@getAllUsers" + e.toString());
		}
		return null;
	}

	public User getSelectedUser(int id) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			User selectedUser = session.createQuery("select u from User u where u.user_id=:id", User.class)
					.setParameter("id", id).getSingleResult();
			tx.commit();
			return selectedUser;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("@get User" + e.toString());
			tx.rollback();
		}

		return null;
	}

	public String updateUser(int id, String name, String email, int amount, String date, String role) {
		Session session = sf.getCurrentSession();
		Transaction tx = session.beginTransaction();
		System.out.println(name+email+amount+role);
		try {
			User selectedUser = session.createQuery("select u from User u where u.user_id=:id", User.class)
					.setParameter("id", id).getSingleResult();
			selectedUser.setEmail(email);
			selectedUser.setName(name);
			selectedUser.setAmount(amount);
			selectedUser.setDate(date);
			selectedUser.setRole(role);

			session.saveOrUpdate(selectedUser);
			tx.commit();
			return "home";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("@update user" + e.toString());
			tx.rollback();
		}

		return "edit";
	}
}
