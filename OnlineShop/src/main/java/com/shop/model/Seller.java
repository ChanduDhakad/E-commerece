package com.shop.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sellerId;

	private String sellerName;

	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;

	private String password;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
	private List<Products> list = new ArrayList<>();
}