package com.app.service;

import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import com.app.doa.UserDao;
import com.app.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	@Transactional
	public List<User> GetUSers() {

		List<User> theUser = userdao.FetchUsers();
		return theUser;

	}

	@Transactional
	public User GetSingleUser(int id) {

		User theUser = userdao.fetchSingleUser(id);
		return theUser;
	}

	@Transactional

	public String UpdateUser(HashMap formUser) {
//		id,email,name,date,amount,date,role
		return userdao.fetchAndUpdate(formUser);
		
	}
}
