package com.mg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mg.entity.Customer;
import com.mg.service.CoustomerService;

@Controller
@RequestMapping("/customer")
public class CoustomerControl {
	
     @Autowired
	private CoustomerService coustomerservice;
	
	@GetMapping("/list")
	public String listCoustomer(Model theModel) {
		List<Customer>theCoustomer= coustomerservice.getCoustomer();
		for(Customer i:theCoustomer) {
			System.out.println(i.getFname());
		}
		theModel.addAttribute("coustomer",theCoustomer);
		return "list-coustomer";
	}
	@GetMapping("/addform")
	public String addform(Model theModel) {
		Customer theCoustomer = new Customer();
		theModel.addAttribute("coustomer",theCoustomer);
		return "addcoustomer";
	}
	@PostMapping("/addcoustomer")
	public String addcoustomer(@ModelAttribute("coustomer") Customer thecoustomer , Model theModel) {
		coustomerservice.saveCoustomer(thecoustomer);
		return "redirect:/customer/list";
		
	}
	@PostMapping("/editform")
	public String editcoustomer(@RequestParam("id") int id, Model theModel) {
		
		Customer theCoustomer =coustomerservice.getCoustomer(id);
		theModel.addAttribute("coustomer", theCoustomer);
		
		return "addcoustomer";
	}
	@PostMapping("/deleterec")
	public String deleterec(@RequestParam("id") int id, Model theModel) {
		
		coustomerservice.deleterec(id);
		
		return "redirect:/customer/list";
	}
	
	
	
	
	
	
}   
