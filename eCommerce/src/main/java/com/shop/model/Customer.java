package com.shop.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;

	@Size(min = 2, max = 10, message = "FirstName should have 2 to 10 characters")
	private String firstName;

	@Size(min = 2, max = 10, message = "LastName should have 2 to 10 characters")
	private String lastName;

	@Email(message = "Invalid email")
	@Column(unique = true)
	private String email;

	@NotNull(message = "Password cannot be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,16}$", message = "Password must be 8 to 16 characters long and include uppercase, lowercase, digit, and special characters")
	private String password;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<CardDetails> card;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Order> orderList;

}
