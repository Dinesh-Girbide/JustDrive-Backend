package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.pojos.Dealer;
import com.app.service.IDealerService;

@RestController 
@RequestMapping("/dealer")
@CrossOrigin(origins = "http://localhost:3000")
public class DealerRestController   {
	@Autowired
	private IDealerService dealerService;
	
	
	@PostMapping("/login/{emailId}/{password}")
	public ResponseEntity<?> loginDealer(@PathVariable String emailId,@PathVariable String password ) {
		System.out.println("in login controller");
		Dealer dealer = dealerService.loginCustomer(emailId, password) ;
		if(dealer != null)
			
		return new ResponseEntity<>(dealer, HttpStatus.CREATED);
		ErrorResponse error = new ErrorResponse("Login Failed : Invalid credential", LocalDateTime.now());
		 return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
