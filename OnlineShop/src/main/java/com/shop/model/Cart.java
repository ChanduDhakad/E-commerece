package com.shop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cartID;
	private Integer totalAmount;

	@JsonIgnore
	@OneToOne	
	private Customer customer;
	

	@JsonIgnore
	@OneToMany
	private List<Product>products=new ArrayList<>();
}
