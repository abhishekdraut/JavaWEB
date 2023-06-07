package com.app.doa;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.app.entity.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory session;

	public List<User> FetchUsers() {
		Session s = session.getCurrentSession();
		try {
			List<User> theUser = s.createQuery("select u from User u", User.class).getResultList();
			return theUser;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("@UserDao" + e.toString());
		}

		return null;

	}

	public User fetchSingleUser(int id) {
		Session s = session.getCurrentSession();
		try {
			User theUser = s.createQuery("select u from User u where u.userId=:id", User.class).setParameter("id", id)
					.getSingleResult();
			return theUser;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("@fetchSINgleUser" + e.toString());
		}

		return null;

	}

	public String fetchAndUpdate(HashMap formData) {
		Session s = session.getCurrentSession();
		try {
			User theUser = s.createQuery("select u from User u where u.userId=:id", User.class).setParameter("id", (int)formData.get("id"))
					.getSingleResult();
			theUser.setName((String)formData.get("name"));
			theUser.setEmail((String)formData.get("email"));
			theUser.setAmount((int)formData.get("amount"));
			theUser.setDate((String)formData.get("date"));
			theUser.setRole((String)formData.get("role"));
			s.saveOrUpdate(theUser);
			return "updated";
		} catch (Exception e) {
			
			System.out.println(e.toString());// TODO: handle exception
		}
		return null;

	}
}
