package com.shop.service;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;

public interface CustomerService {
  public Customer registor(Customer customer);
 public Customer getCustomerById(Integer id)throws CustomerException;
}
