package com.shop.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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

	@Column(length = 16, nullable = false)
	@NotNull(message = "Password cannot be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,16}$", message = "Password must be 8 to 16 characters long and include uppercase, lowercase, digit, and special characters")
	private String password;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
	private List<Products> list = new ArrayList<>();
}