package com.app.service;

import java.util.List;

import com.app.pojos.Bookings;

public interface IBookingsService {
	List<Bookings> findByCustomerID(int Id);
}
