package com.shop.service;

import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.CustomerException;
import com.shop.exception.LoginException;
import com.shop.model.Address;
import com.shop.model.AddressDTO;
import com.shop.model.Customer;

public interface CustomerService {
public Customer AddCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(String key,Customer customer)throws CustomerException,LoginException;
	
	public Address AddAddress(AddressDTO address,String key,Integer CustomerId)throws CustomerException,LoginException;
	
	public String deleteCustomer(Integer customerId, String key)throws CustomerException,LoginException;
	
}
