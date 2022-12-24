package com.customertracker.dao;

import java.util.List;

import com.customertracker.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();
	
}
