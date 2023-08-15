package com.shop.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;
import com.shop.service.CustomerService;

import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerException{
		
		Customer newCustomer = cService.AddCustomer(customer);
		
		return new ResponseEntity<Customer>(newCustomer,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/UpdateCustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestParam String key,@RequestBody  Customer customer) throws CustomerException, LoginException{
		
		Customer updatedcustomer= cService.updateCustomer(key, customer);
		
		return new ResponseEntity<Customer>(updatedcustomer,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/AddAddress")
	public ResponseEntity<Address> addAddressHandler(@RequestBody AddressDTO address,String key,Integer customerId) throws CustomerException, LoginException{
		
		Address addr= cService.AddAddress(address, key, customerId);
		
		return new ResponseEntity<Address>(addr,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("/deleteCustomer")
	public ResponseEntity<String> deleteCustomerHandler(Integer customerId ,String key) throws CustomerException, LoginException{
		
		String message= cService.deleteCustomer(customerId, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
	
}

