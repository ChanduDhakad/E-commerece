package com.shop.service;

import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.CustomerException;
import com.shop.exception.LoginException;
import com.shop.model.Customer;

public interface CustomerService {
	public Customer registor(Customer customer);
//	public Customer updateCustomerDetails(Customer customer ,String loginKey) throws CustomerException;
	public Customer deleteCustomerAccount(Integer id, String loginKey) throws CustomerException,LoginException ;
	public List<Customer> findAllCustomer(String adminKey) throws AdminException, LoginException;
	public Customer getCustomerById(Integer id)throws CustomerException;
	
}
