package com.shop.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class  Feedback{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedBackId;
	
	@Min(1)
	@Max(5)
	private Integer productRating;
	
	@Min(1)
	@Max(5)
	private Integer serviceRating;
	
	@Min(1)
	@Max(5)
	private Integer overAllRating;
	
	@NotNull(message = "Message Cannot be Null")
	private String Message;
	
	private LocalDate localdate;
	
	@OneToOne
	@JsonIgnore
	private Customer customer;
	
	@OneToOne
	@JsonIgnore
	private Order order;
}