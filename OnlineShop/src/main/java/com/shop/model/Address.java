package com.shop.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor

@Entity
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressID;

	private String street;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String addressType;

	
	@JsonIgnore
	@ManyToOne
	private Customer customer;

}
