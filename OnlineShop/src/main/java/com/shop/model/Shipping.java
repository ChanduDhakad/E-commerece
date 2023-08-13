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

@Data
@AllArgsConstructor
@Entity

public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shippingID;
	private String trakingNumber;
	private String carrier;

	private String status;

	private LocalDateTime shipDate;
	private LocalDateTime deliveryDate;
	@OneToMany
	private List<Order> order;

	@OneToOne
	private Address address;
}
