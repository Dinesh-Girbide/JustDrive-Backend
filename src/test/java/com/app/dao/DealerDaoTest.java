package com.app.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Dealer;

@SpringBootTest
public class DealerDaoTest {
	@Autowired
	DealerRepository dealerRepo;
	
	@Test
	void testAddNewDealer() {
		List<Dealer> dealer=Arrays.asList(
				new Dealer("nitesh", "nitesh@gmail.com", "pass123", 123456,"pune", "18.2334", "73.5678"),
				new Dealer("omkar", "omkar@gmail.com", "pass456", 223344,"pune", "11.2334", "89.5678")
				);
		dealerRepo.saveAll(dealer);

	}
	}


