package com.customertracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customertracker.dao.CustomerDAO;
import com.customertracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerDAO customerdao;
	
	@RequestMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> customers=customerdao.getCustomers();
		model.addAttribute("customers",customers);
		return "list-customers";
	}
}
