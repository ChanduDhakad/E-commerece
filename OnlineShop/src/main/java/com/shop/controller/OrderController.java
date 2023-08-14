package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shop.exception.*;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.service.*;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public ResponseEntity<Order> crateOrder( @RequestBody Order order,@RequestParam Integer categoryID,@RequestParam String key) throws OrderException, CustomerException, LoginException, CartException  {
		Order o= orderService.createOrder(order, categoryID, key);
		return new ResponseEntity<Order>(o, HttpStatus.CREATED);
	}
	
	
}
