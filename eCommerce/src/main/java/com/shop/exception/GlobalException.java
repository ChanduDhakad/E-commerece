package com.shop.exception;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> AddressException(AddressException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(CardException.class)
	public ResponseEntity<MyErrorDetails> CardException(CardException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> CartException(CartException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerException(CustomerException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> LoginException(LoginException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> OrderException(OrderException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyErrorDetails> ProductException(ProductException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(SellerException.class)
	public ResponseEntity<MyErrorDetails> SellerException(SellerException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<MyErrorDetails> paymentException(PaymentException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetails> FeedBackException(FeedbackException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> AdminException(AdminException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(ConstraintViolationException me) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				me.getMessage());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> NoHandlerFoundException(NoHandlerFoundException ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> AllException(Exception ad, WebRequest wrq) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocaldateTime(LocalDateTime.now());
		err.setMessage(ad.getMessage());
		err.setDescription(wrq.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_GATEWAY);
	}

}