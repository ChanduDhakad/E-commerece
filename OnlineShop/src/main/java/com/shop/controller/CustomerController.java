package com.shop.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;
import com.shop.service.CustomerService;



@RestController
public class CustomerController {

	@Autowired
	CustomerService cs;

	@GetMapping("/hello")
	public String helloWord() {
		return "Hello Chandra Prakash";

	}

	@PostMapping("/registor")
	public ResponseEntity<Customer> registor(@Valid @RequestBody Customer customer) {
		System.out.println(customer);
		Customer customer2 = cs.registor(customer);
		return new ResponseEntity<>(customer2, HttpStatus.CREATED);

	}
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) throws CustomerException {
		
		Customer customer2 = cs.getCustomerById(id);
		return new ResponseEntity<>(customer2, HttpStatus.CREATED);

	}

}
