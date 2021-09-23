package com.app.service;

import java.util.List;

import com.app.pojos.Customer;

public interface ICustomerService {
	//add a method to save new customer details
	Customer saveNewCustomer(Customer transientUser);

	//login customer with email and password
	Customer loginCustomer(String email,String password);
	
	//get all customer details
	List<Customer> getAllCustomers();
	//List<User> fetchAllUsers();
}
