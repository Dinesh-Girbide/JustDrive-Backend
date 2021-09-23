package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.BookingsRepository;
import com.app.pojos.Bookings;
@Service
@Transactional
public class BookingsServiceImpl implements IBookingsService {
	@Autowired
	private BookingsRepository bookingRepo;

	@Override
	public List<Bookings> findByCustomerID(int Id) {

		return bookingRepo.findByCustomerID(Id);
	}

}
