package com.shop.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerExceptionHandler(CustomerException ce,WebRequest rs) {		
		 MyErrorDetails err=new MyErrorDetails(ce.getMessage(), LocalDateTime.now(),rs.getDescription(false));
		 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		 
	}
}
