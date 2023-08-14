package com.shop.model;


import javax.persistence.*;
import lombok.*;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
//	@NotNull(message = "Please enter the username")
	
//	@ManyToOne
//    @JoinColumn(name = "username", referencedColumnName = "username")
//    private UniqueUsername uniqueUsername;
	private String userName;
	//@NotBlank(message = "Password cannot be blank")
//	@Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit")
	private String password;

}
