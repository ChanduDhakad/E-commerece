package com.shop.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderID;

	private LocalDateTime orderDate;
	
//	@Enumerated
//	private Status status;

	private String billingAddress;
	private String deliveryAddress;

	@OneToOne
	private Customer customer;
}
