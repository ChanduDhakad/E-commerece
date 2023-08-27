package com.shop.service;

import com.shop.exception.*;
import com.shop.model.*;

public interface CustomerService {
	
	public Customer AddCustomer(Customer customer) throws CustomerException;

	public Customer updateCustomer(String key, Customer customer) throws CustomerException, LoginException;

	public Address AddAddress(AddressDTO address, String key, Integer CustomerId)throws CustomerException, LoginException;

	public String deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException;

}
