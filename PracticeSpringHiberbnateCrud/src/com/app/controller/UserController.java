package com.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.app.entity.User;
import com.app.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userservice;

	@GetMapping("/getUserList")
	public String GetUsers(Model theModel) {

		List<User> theUsers = userservice.GetUSers();
		theModel.addAttribute("users", theUsers);
		return "user";
	}

	@GetMapping("/getSingleUser")
	public String GetSingleUser(@RequestParam("userId") int id, Model theModel) {

		User theUser = userservice.GetSingleUser(id);
		theModel.addAttribute("user", theUser);
		return "edit";
	}

	@PostMapping("/SubmitForm")
	public String UpdateUser(@RequestParam("formId") int id, @RequestParam("formName") String name,
			@RequestParam("formEmail") String email,@RequestParam("formAmount") int amount,@RequestParam("formDate") String date,@RequestParam("formRole") String role) {

		HashMap temp=new HashMap();
		temp.put("id", id);
		temp.put("name", name);
		temp.put("email", email);
		temp.put("amount", amount);
		temp.put("date", date);
		temp.put("role",role);
		
		
		
		String result=userservice.UpdateUser(temp);
		
		if(result=="updated") {
			return "redirect:getUserList";
		}
		return "redirect:getSingleUser?userId="+id;
	}
}
