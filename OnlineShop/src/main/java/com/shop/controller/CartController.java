package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.exception.*;
import com.shop.model.Cart;
import com.shop.model.Category;
import com.shop.service.CartService;
import com.shop.service.CategoryService;

@RestController
public class CartController {

	@Autowired
	private CartService  CartService;

	@PostMapping("/cart")
	public ResponseEntity<Cart> addNewCart(@RequestParam String userKey, @RequestBody Cart cart) throws CustomerException, CartException, LoginException  {
		Cart c = CartService.addNewCart(cart, userKey);
		return new ResponseEntity<Cart>(c, HttpStatus.CREATED);
	}
	
	@PutMapping("/cart")
	public ResponseEntity<Cart> addNewProductIntoCart(@RequestParam Integer cardID,@RequestParam Integer productID,@RequestParam String userKey) throws CartException, ProductException, LoginException, CustomerException  {
		Cart c = CartService.addNewProductIntoCart(cardID, productID, userKey);
		return new ResponseEntity<Cart>(c, HttpStatus.CREATED);
	}
	

}
