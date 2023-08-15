package com.shop.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor


@NoArgsConstructor
public class AddressDTO {

	private String streetNo;
	private String buildingName;
	private String city;
	private String state;
	private String country;
	private String pincode;
}
