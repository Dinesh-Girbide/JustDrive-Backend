package com.app.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class City extends BaseEntity {
	@Column(length = 20, nullable = false)
	private String cityName;
	@Column(length = 20, nullable = false)
	private String cityState;
	@Column(length = 20, nullable = false)
	private String cityCountry;

	private int pincode;

//Links to other Tables
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("city")
	private List<Dealer> dealerList;

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", cityState=" + cityState + ", cityCountry=" + cityCountry + ", pincode="
				+ pincode + "]";
	}

}
