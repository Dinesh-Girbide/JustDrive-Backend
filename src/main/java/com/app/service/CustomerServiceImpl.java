package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CustomerRepository;
import com.app.pojos.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	// dependency
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer saveNewCustomer(Customer transientCustomer) {
		return custRepo.save(transientCustomer);
	}

	@Override
	public Customer loginCustomer(String email, String password) {
		// Customer customer = custRepo.findByCustomerEmailAndPassword(email, password);
		Customer cust1 = custRepo.findByEmailAndPassword(email, password);
		
			return cust1;
		
	}

	@Override
	public List<Customer> getAllCustomers() {

		return custRepo.findAll();
	}

}
