package com.shop.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer newCustomer = cService.AddCustomer(customer);

		return new ResponseEntity<Customer>(newCustomer, HttpStatus.ACCEPTED);
	}

	@PutMapping("/UpdateCustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestParam String key, @RequestBody Customer customer)
			throws CustomerException, LoginException {

		Customer updatedcustomer = cService.updateCustomer(key, customer);

		return new ResponseEntity<Customer>(updatedcustomer, HttpStatus.ACCEPTED);

	}

	@PutMapping("/AddAddress")
	public ResponseEntity<Address> addAddressHandler(@RequestBody AddressDTO address, String key, Integer customerId)
			throws CustomerException, LoginException {

		Address addr = cService.AddAddress(address, key, customerId);

		return new ResponseEntity<Address>(addr, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<String> deleteCustomerHandler(Integer customerId, String key)
			throws CustomerException, LoginException {

		String message = cService.deleteCustomer(customerId, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}
