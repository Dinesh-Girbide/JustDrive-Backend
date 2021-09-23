package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings,Integer> {

	//List<Bookings> findByCustomer();
	@Query("select b from Bookings b where b.customerDetails.id=:id")
	List<Bookings> findByCustomerID(@Param("id") int id);
}
