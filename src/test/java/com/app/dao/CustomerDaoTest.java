package com.app.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Customer;

@SpringBootTest
public class CustomerDaoTest {
	@Autowired
	CustomerRepository custRepo;
	
	@Test
	void testAddNewCustomer() {
		List<Customer> customer=Arrays.asList(
				new Customer("ramesh", "nayar", "ramesh@gmail.com", "ramesh12345", 98989898, "PQ1234", "image1"),
				new Customer("swati", "salunkhe", "swati@gmail.com", "swati2345", 77889944, "GH1234", "image2"),
				new Customer("sam", "cooper", "sam@gmail.com", "sam2345", 66889977, "RS1234", "image3"));
		custRepo.saveAll(customer);

	}
	}


