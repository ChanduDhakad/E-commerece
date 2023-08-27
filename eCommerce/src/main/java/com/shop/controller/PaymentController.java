package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class PaymentController {

	@Autowired
	private paymentServices pservice;

	@PostMapping("/makePayments")
	public ResponseEntity<Payment> MakePaymentHandler(@RequestParam Integer orderId, @RequestParam Integer cardId,
			@RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException, CardException {

		Payment pay = pservice.makePayment(orderId, cardId, customerId, key);

		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

	@GetMapping("/viewPayment/{paymentId}")
	public ResponseEntity<Payment> viewPaymentDetailsHandler(@PathVariable Integer paymentId,
			@RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException {

		Payment pay = pservice.viewPaymentDetailsById(paymentId, customerId, key);

		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

	@GetMapping("/viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPaymentDetailsHandler(@RequestParam Integer customerId,
			@RequestParam String key) throws LoginException, CustomerException, OrderException, PaymentException {

		List<Payment> pay = pservice.getAllPaymentByCustomer(customerId, key);

		return new ResponseEntity<List<Payment>>(pay, HttpStatus.OK);
	}

	public ResponseEntity<String> cancelPaymentHandler(@PathVariable Integer paymentId,
			@RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, PaymentException {

		String message = pservice.cancelPayment(paymentId, customerId, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}