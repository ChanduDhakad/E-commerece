package com.shop.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;

	@Size(min = 3, max = 10, message = "UserName Should be of 3 to 10 Characters.")
	@Column(unique = true)
	private String userName;

	@Column(length = 16, nullable = false)
	@NotNull(message = "Password cannot be null")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?!.*\\s).{8,16}$", message = "Password must be 8 to 16 characters long and include uppercase, lowercase, digit, and special characters")
	private String password;

	@Email(message = "Please Enter the Valid EmailAddress")
	@Column(unique = true)
	private String email;

}
