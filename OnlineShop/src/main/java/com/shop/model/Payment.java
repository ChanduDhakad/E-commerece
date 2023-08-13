package com.shop.model;




import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentID;
	private Integer amount;
	private String currency;
	
	private String paymentMethod;
	private String paymentStatus;
	private LocalDateTime timestamp;
    
	@OneToOne
	private Order order;
	

}
