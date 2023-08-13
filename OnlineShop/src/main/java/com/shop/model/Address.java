package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NegativeOrZero;

import org.hibernate.annotations.GeneratorType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NegativeOrZero
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressID;
	
	private String street;
	private String city;
	private String  state;
	private String country;
	private String postalCode;	
	private String addressType;
	
	@ManyToOne	
	private Customer customer;
	
	
}
