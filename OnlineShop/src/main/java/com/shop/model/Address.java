package com.shop.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor

@Entity

@RequiredArgsConstructor
public class Address {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;

	public Address(String streetNo, String buildingName, String city, String state, String country, String pincode) {
		super();
		this.streetNo = streetNo;
		this.buildingName = buildingName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	
}
