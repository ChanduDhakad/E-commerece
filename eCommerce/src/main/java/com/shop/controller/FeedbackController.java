package com.shop.controller;

import java.util.List;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class FeedbackController {

	@Autowired
	private FeedBackService fServices;

	@PostMapping("addFeedBack")
	public ResponseEntity<Feedback> addFeedBackHandler(@Valid @RequestBody FeedbackDTO feedback,
			@RequestParam Integer orderId, @RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {

		Feedback feed = fServices.AddFeedBack(feedback, orderId, customerId, key);

		return new ResponseEntity<Feedback>(feed, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updatefeedback")
	public ResponseEntity<Feedback> updateFeedBackHandler(@RequestBody FeedbackDTO feedback,
			@RequestParam Integer feedbackId, @RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {

		Feedback feed = fServices.updateFeedback(feedback, feedbackId, customerId, key);

		return new ResponseEntity<Feedback>(feed, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deletefeedback")
	public ResponseEntity<String> deleteFeedBackHandler(@RequestParam Integer feedbackId,
			@RequestParam Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {

		String feed = fServices.deletefeedback(feedbackId, customerId, key);

		return new ResponseEntity<String>(feed, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAllfeedback/{customerId}")
	public ResponseEntity<List<Feedback>> viewAllFeedBackHandler(@PathVariable Integer customerId,
			@RequestParam String key) throws LoginException, CustomerException, OrderException, FeedbackException {

		List<Feedback> feed = fServices.viewAllFeedback(customerId, key);

		return new ResponseEntity<List<Feedback>>(feed, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAllfeedbackById/{customerId}")
	public ResponseEntity<Feedback> viewAllFeedBackByIdHandler(@RequestParam Integer feedbackId,
			@PathVariable Integer customerId, @RequestParam String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {

		Feedback feed = fServices.viewFeedBackById(feedbackId, customerId, key);

		return new ResponseEntity<Feedback>(feed, HttpStatus.ACCEPTED);
	}

}