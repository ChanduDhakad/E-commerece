package com.shop.model;

import java.time.*;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;

	private LocalDate orderDate;

	private String orderStatus;

	private double orderAmount;

	@JsonIgnore
	@ManyToOne
	private Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ProductDTO> productList;

	@OneToOne
	@JsonIgnore
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Payment payment;

}