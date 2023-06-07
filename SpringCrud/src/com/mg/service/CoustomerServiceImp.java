package com.mg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mg.dao.CoustomerDao;
import com.mg.entity.Customer;
@Service
public class CoustomerServiceImp implements CoustomerService {
	@Autowired
	private CoustomerDao customerdao;
	
      
	@Override
	@Transactional
	public List<Customer> getCoustomer() {
		
		return customerdao.getCoustomer();
	}

	@Override
	@Transactional
	public void saveCoustomer(Customer theCoustomer) {
		customerdao.saveCoustomer(theCoustomer);
		
	}

	@Override
	@Transactional
	public Customer getCoustomer(int theid) {
		
		return customerdao.getCoustomer(theid);
	}

	@Override
	@Transactional
	public void deleterec(int theid) {
		customerdao.deleterec(theid);
	}
	

}
