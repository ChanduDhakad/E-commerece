package com.shop.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class CartController {

	@Autowired
	private CartServices cService;

	@PostMapping("/AddProductToCart")
	public ResponseEntity<Cart> addProductToCartHandler(@RequestParam Integer ProductId, @RequestParam String key,
			@RequestParam Integer CustomerId) throws LoginException, CustomerException, ProductException {
		Cart cart = cService.AddProductToCart(ProductId, key, CustomerId);

		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
	}

	@PutMapping("/decreaseQuantity")
	public ResponseEntity<Cart> decreaseQuantityofProductHandler(@RequestParam Integer productId,
			@RequestParam String key, @RequestParam Integer customerId, @RequestParam Integer Quantity)
			throws LoginException, CustomerException, ProductException, CartException {
		Cart cart = cService.descreaseQuantityOfProduct(productId, key, customerId, Quantity);

		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
	}

	@PutMapping("/removeProductFromCart")
	public ResponseEntity<Cart> removeProductFromCartHandler(@RequestParam Integer productId, @RequestParam String Key,
			@RequestParam Integer customerId)
			throws LoginException, CustomerException, ProductException, CartException {

		Cart cart = cService.removeProductFromCart(productId, Key, customerId);

		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
	}

	@PutMapping("/emptyCart")
	public ResponseEntity<Cart> emptyCartHandler(@RequestParam String Key, @RequestParam Integer customerId)
			throws LoginException, CustomerException, CartException {

		Cart cart = cService.emptycart(Key, customerId);
		return new ResponseEntity<Cart>(cart, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAllCartProducts")
	public ResponseEntity<Map<String, Integer>> getAllProductInCartHandler(@RequestParam String Key,
			@RequestParam Integer customerId) throws LoginException, CustomerException, CartException {

		// List<Products> plist = cService.getAllProductInCart(customerId, Key);
		Map<String, Integer> plist = cService.getAllProductInCart(customerId, Key);
		return new ResponseEntity<Map<String, Integer>>(plist, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getCartValue")
	public ResponseEntity<Integer> getCartValueHandler(@RequestParam String Key, @RequestParam Integer customerId)
			throws LoginException, CustomerException {

		Integer value = cService.getCartValue(customerId, Key);

		return new ResponseEntity<Integer>(value, HttpStatus.ACCEPTED);
	}

}