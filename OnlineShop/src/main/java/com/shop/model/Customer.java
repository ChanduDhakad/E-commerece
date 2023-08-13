package com.shop.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
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
	private String userName;

	//@NotNull(message = "Please enter the password")
	//@Size(max = 15, min = 8, message = "Your password should be at least of 8 charecters and at most of 15 charecters")
	private String password;

	//@NotNull(message = "Please enter the Firstname")
	private String firstName;

	//@NotNull(message = "Please enter the lastname")
	private String lastName;

	//@NotNull(message = "Please enter the contact")
	private long contact;
//
	//@NotNull(message = "Please enter the email")
	//@Email(message = "Please enter a valid email id")
	private String email;
	
	@OneToMany
	private List<Address> address;

}
