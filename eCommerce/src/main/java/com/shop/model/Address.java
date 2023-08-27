package com.shop.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor

@Entity

@RequiredArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;

	@NotBlank(message = "Street number is required")
	private String streetNo;

	@NotBlank(message = "Building name is required")
	private String buildingName;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "State is required")
	private String state;

	@NotBlank(message = "Country is required")
	private String country;

	@NotBlank(message = "Pincode is required")
	@Pattern(regexp = "\\d{6}", message = "Pincode should be a 6-digit number")
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
