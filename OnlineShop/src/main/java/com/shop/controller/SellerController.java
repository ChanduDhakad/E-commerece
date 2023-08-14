package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.exception.*;
import com.shop.model.Seller;

import com.shop.service.SellerService;

@RestController
public class SellerController {

	@Autowired
	private SellerService  sellerService;

	@PostMapping("/seller/{key}")
	public ResponseEntity<Seller> addNewSeller(@RequestParam String key, @RequestBody Seller seller) throws AdminException, LoginException, SellerException {
		Seller s = sellerService.addNewSeller(seller, key);
		return new ResponseEntity<Seller>(s, HttpStatus.CREATED);
	}
	
	/*
	
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateUserHandler(@Valid @RequestParam(required = false) String key,
			@RequestBody Admin user) throws AdminException, LoginException {
		Admin updatedUser = aService.updateAdmin(user, key);
		return new ResponseEntity<Admin>(updatedUser, HttpStatus.OK);
	}
	
	*/
}
