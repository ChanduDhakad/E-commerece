package com.shop.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor


public class MyErrorDetails {

	private String msg;
	private LocalDateTime localDateTime;
	private String desc;
}
