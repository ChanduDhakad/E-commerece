package com.shop.model;

import java.time.LocalDateTime;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "currentUsers")
public class CurrentUser {

	@Id
	@Column(unique = true)
	private int userId;
	private String uuid;
	private Boolean admin;
	private LocalDateTime timestamp;

}
