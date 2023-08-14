package com.shop.model;


import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class LoginDTO {
	
	private String username;
	private String password;
		
}
