package com.app.pojos;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bookings")
@NoArgsConstructor
@Setter
@Getter
public class Bookings extends BaseEntity {
	private LocalDate pickupDate;
	private LocalTime pickupTime;
	private LocalDate returnDate;
	private LocalTime returnTime;
	private int totalday;
	private double dailyRate;
	private double totalFare;
	private double gst;
	private double advancePayment;
	@Column(length = 20)
	private String paymentMode;
	private Timestamp bookingDateTime;
	private BookingStatus bookingStatus;
	
	
//Links to other Tables

	@ManyToOne
	@JoinColumn(name = "cutomer_fk")
	@JsonIgnoreProperties("bookingHistory")
	private Customer customerDetails;

	@ManyToOne
	@JoinColumn(name = "car_fk")
	private Car carDetails;

	@Override
	public String toString() {
		return "Bookings [pickupDate=" + pickupDate + ", pickupTime=" + pickupTime + ", returnDate=" + returnDate
				+ ", returnTime=" + returnTime + ", totalday=" + totalday + ", dailyRate=" + dailyRate + ", totalFare="
				+ totalFare + ", gst=" + gst + ", advancePayment=" + advancePayment + ", paymentMode=" + paymentMode
				+ ", bookingDateTime=" + bookingDateTime + "]";
	}

}
