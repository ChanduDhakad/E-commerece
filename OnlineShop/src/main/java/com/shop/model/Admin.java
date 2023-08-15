package com.shop.model;


import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@NotNull
	private String Password;

}
