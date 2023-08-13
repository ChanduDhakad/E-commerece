package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sellerID;
	private String name;
	private String email;
	private String phoneNumber;
	
	@OneToOne
	private Address address;

}
