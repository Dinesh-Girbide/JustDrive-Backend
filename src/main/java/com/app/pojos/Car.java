package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Car extends BaseEntity {
	@Column(length = 20, nullable = false,unique = true)
	private String carNo;
	@Column(length = 20)
	private String carCompany;
	@Column(length = 20)
	private String CarModel;
	@Column(length = 10)
	private String fuelType;

	private String carRCImage;

	private double dailyRate;
	
	private boolean carStatus;

//Links to other tables
	@ManyToOne
	@JoinColumn(name = "dealer_fk")
	
	private Dealer dealer;

	@ManyToOne
	@JoinColumn(name = "carType_fk")
	@JsonIgnoreProperties("carList")
	private CarType carType;

	@Override
	public String toString() {
		return "Car [carNo=" + carNo + ", carCompany=" + carCompany + ", CarModel=" + CarModel + ", fuelType="
				+ fuelType + ", carRCImage=" + carRCImage + ", dailyRate=" + dailyRate + ", status=" + carStatus + "]";
	}

}
