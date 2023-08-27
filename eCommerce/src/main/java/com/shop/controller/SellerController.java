package com.shop.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class SellerController {

	@Autowired
	private SellerService sService;

	@PostMapping("/AddSeller")
	public ResponseEntity<Seller> AddSellerHandler(@Valid @RequestBody Seller seller) throws SellerException {

		Seller resultSeller = sService.insertSeller(seller);

		return new ResponseEntity<Seller>(resultSeller, HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateName")
	public ResponseEntity<Seller> updateNameHandler(@RequestParam Integer sellerId, @RequestParam String key,
			@RequestParam String SellerName) throws SellerException, LoginException {

		Seller sell = sService.updateName(sellerId, key, SellerName);

		return new ResponseEntity<Seller>(sell, HttpStatus.OK);
	}

	@DeleteMapping("/deleteSeller")
	public ResponseEntity<String> deleteSellerHandler(@RequestParam Integer sellerId, @RequestParam String key)
			throws SellerException, LoginException {
		String message = sService.deleteSeller(sellerId, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}
