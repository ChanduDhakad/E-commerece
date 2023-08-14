package com.shop.model;




import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentID;
	
	//@JsonIgnore
	private Integer amount;
	
	//@JsonIgnore
	private String currency;
	
	private String paymentMethod;
	private String paymentStatus;
	
	//@JsonIgnore
	private LocalDateTime timestamp;
    

	//@JsonIgnore
	@OneToOne
	private Order order;
	

}
