package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shop.exception.*;
import com.shop.model.Payment;
import com.shop.model.Product;
import com.shop.service.*;

@RestController
public class PaymentController {

	@Autowired
	private PaymentService  paymentService;

	@PostMapping("/payment")
	public ResponseEntity<Payment> addNewProduct( @RequestBody Payment payment,@RequestParam Integer orderID,@RequestParam String key) throws PaymentException, OrderException, LoginException, CustomerException {
		Payment p = paymentService.cratePayment(payment, orderID,key);
		return new ResponseEntity<Payment>(p, HttpStatus.CREATED);
	}
	
	
}
