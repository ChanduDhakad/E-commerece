package com.shop.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;

//    @NotNull(message = "Please enter the username")
//	@Size(min = 3, message = "Please enter atleast 3 charecter")
//	@ManyToOne
//	@JoinColumn(name = "username", referencedColumnName = "username")
//	private UniqueUsername uniqueUsername;

	// @NotNull(message = "Please enter the password")
	// @Size(max = 15, min = 8, message = "Your password should be at least of 8
	// charecters and at most of 15 charecters")
	
	private String userName;
	private String password;

	// @NotNull(message = "Please enter the Firstname")
	private String firstName;

	// @NotNull(message = "Please enter the lastname")
	private String lastName;

	// @NotNull(message = "Please enter the contact")
	private Integer contact;
//
	// @NotNull(message = "Please enter the email")
	// @Email(message = "Please enter a valid email id")
	private String email;

	
	@JsonIgnore
	@OneToMany
	private List<Address> address;

}
