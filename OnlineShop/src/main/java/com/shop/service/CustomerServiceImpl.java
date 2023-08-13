package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.CustomerException;
import com.shop.model.Customer;
import com.shop.repository.CustomerRepository;



@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerRepository cr;
	
	@Override
	public Customer registor(Customer customer) {
		
		Customer c=cr.save(customer);
		return c;
	}

	@Override
	public Customer getCustomerById(Integer id)throws CustomerException {
		  Optional<Customer> opt=cr.findById(id);
		  if(opt.isEmpty()) {
			  throw new CustomerException("Id Value is present in database");
		  }
		  return opt.get();
	}

}
