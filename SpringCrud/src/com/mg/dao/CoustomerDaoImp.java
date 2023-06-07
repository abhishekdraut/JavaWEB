package com.mg.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mg.entity.Customer;
@Repository
public class CoustomerDaoImp implements CoustomerDao {
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<Customer> getCoustomer() {
		Session session = sessionfactory.getCurrentSession();
		Query<Customer>theQuery=session.createQuery("from Customer", Customer.class);
		List<Customer> customer=theQuery.getResultList();
		
		
		return customer;
	}

	@Override
	public void saveCoustomer(Customer theCoustomer) {
		Session session =sessionfactory.getCurrentSession();
		session.saveOrUpdate(theCoustomer);
		
	}

	@Override
	public Customer getCoustomer(int theid) {
		Session session = sessionfactory.getCurrentSession();
		Customer theCoustomer = session.get(Customer.class, theid);
		return theCoustomer;
	}

	@Override
	public void deleterec(int theid) {
		Session session = sessionfactory.getCurrentSession();
		Customer theCoustomer = session.get(Customer.class, theid);
		session.delete(theCoustomer);
	}

}
