package com.shop.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
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
