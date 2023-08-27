package com.shop.model;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cardId;

	@NotBlank(message = "Card number is required")
	@Size(min = 13, max = 19, message = "Card number must be between 13 and 19 characters")
	private String cardNumber;

	@Transient

	@NotNull(message = "CVV is required")
	@Min(value = 100, message = "CVV must be a 3-digit number")
	@Max(value = 999, message = "CVV must be a 3-digit number")
	private Integer cvv;

	@DateTimeFormat(pattern = "MM/yy")
	@NotNull(message = "Valid from date is required")
	private LocalDate validFrom;

	@DateTimeFormat(pattern = "MM/yy")
	@NotNull(message = "Valid to date is required")
	private LocalDate validTo;
}
