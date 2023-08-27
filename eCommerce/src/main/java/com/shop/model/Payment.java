package com.shop.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;
	
	private boolean paymentStatus;
	
	private Integer paymentAmount;
	
	private LocalDate DateOfPayment;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private CardDetails card;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Order order;
	
}