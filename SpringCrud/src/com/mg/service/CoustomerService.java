package com.mg.service;

import java.util.List;

import com.mg.entity.Customer;

public interface CoustomerService {

	public List<Customer> getCoustomer();
	public void saveCoustomer(Customer theCoustomer);
	public Customer getCoustomer(int theid);
	public void deleterec(int theid);
	
}
