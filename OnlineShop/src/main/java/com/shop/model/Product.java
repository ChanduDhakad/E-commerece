package com.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productID;
	private String name;
	private String description;
	private Integer price;
	private String currency;
    
	@ManyToOne	
	private Category category;
	
	@ManyToOne
	private Seller seller;
}
