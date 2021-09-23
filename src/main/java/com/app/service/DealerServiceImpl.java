package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.DealerRepository;
import com.app.pojos.Dealer;
@Service
@Transactional
public class DealerServiceImpl implements IDealerService {
	@Autowired
	private DealerRepository dealerRepo;

	@Override
	public Dealer loginCustomer(String email, String password) {
		return dealerRepo.findByEmailAndPassword(email, password);
	}

}
