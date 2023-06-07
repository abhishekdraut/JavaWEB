package com.mg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mg.entity.Student;
@Repository
public class MyDao2 {
	@Autowired
	private SessionFactory session;
	
	private List<Student> std;

	public MyDao2() {
		System.out.println("my dao 2 instantiated");
		std=new ArrayList <Student>();
		std.add(new Student(111,"Mahesh","Ghodekar","mahesh@gmail.com"));
		std.add(new Student(112,"Kalpesh","Ghodekar","mahesh@gmail.com"));
		std.add(new Student(113,"Roshan","Ghodekar","mahesh@gmail.com"));
		std.add(new Student(114,"Shivam","Ghodekar","mahesh@gmail.com"));
	}

	public List<Student> GetAllUserList() {
//		Session s = session.getCurrentSession();

		try {
//			List<Student> students = s.createQuery("select s from Student s",Student.class).getResultList();
//			return students;
			return (List<Student>)std;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

}