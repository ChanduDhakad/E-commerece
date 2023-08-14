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
	public ResponseEntity<MyErrorDetails> CustomerExceptionHandler(CustomerException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> adminExceptionHandler(AdminException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> productExceptionHandler(ProductException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SellerException.class)
	public ResponseEntity<MyErrorDetails> sellerExceptionHandler(SellerException ce, WebRequest rs) {
		MyErrorDetails err = new MyErrorDetails(ce.getMessage(), rs.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
}
