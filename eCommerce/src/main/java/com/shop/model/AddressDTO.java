package com.shop.model;

import javax.validation.constraints.*;

import lombok.*;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class AddressDTO {

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
}
