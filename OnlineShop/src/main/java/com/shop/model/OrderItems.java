package com.shop.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemID;

	private LocalDateTime orderDate;
	private Status status;

	private String billingAddress;
	private String deliveryAddress;

	@ManyToOne
	private Order order;
	
	@OneToMany
	private List<Product> product;
	private String quantity;
	private Integer price;
}
