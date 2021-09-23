package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.pojos.Bookings;
import com.app.pojos.Customer;
import com.app.service.IBookingsService;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRestController {

	@Autowired
	ICustomerService custService;

	@Autowired
	IBookingsService bookingsService;

	public CustomerRestController() {
		System.out.println("in const of " + getClass().getName());
	}

//	@GetMapping("/allcustomerlist")
//	public List<Customer> getAllCustomers() {
//		System.out.println("in get all customers");
//		return custService.getAllCustomers();
//	}

	@GetMapping("/bookingslist/{Id}")
	public ResponseEntity<?> getAllBookingsListByCustId(@PathVariable int Id) {
		List<Bookings> bookingsList = bookingsService.findByCustomerID(Id);
		return new ResponseEntity<>(bookingsList,HttpStatus.FOUND);
	}

	@PostMapping("/login/{emailId}/{password}")
	public ResponseEntity<?> loginCustomer(@PathVariable String emailId, @PathVariable String password) {
		System.out.println("in login controller");
		Customer customer = custService.loginCustomer(emailId, password);
		if (customer != null)

			return new ResponseEntity<>(customer, HttpStatus.CREATED);
		ErrorResponse error = new ErrorResponse("Login Failed : Invalid credential", LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> signupCustomer(@RequestBody Customer customer) {
		System.out.println("in save customer " + customer);// user : not null , except id

		return new ResponseEntity<>(custService.saveNewCustomer(customer), HttpStatus.CREATED);

	}

}
