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
public class CurrentUserSession {

	@Id
	@Column(unique = true)
	private Integer userId;
	private LocalDateTime timestamp;
	private String uuid;

}
