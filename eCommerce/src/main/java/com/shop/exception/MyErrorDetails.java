package com.shop.exception;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetails {

	private LocalDateTime localdateTime;
	private String Message;
	private String Description;
}