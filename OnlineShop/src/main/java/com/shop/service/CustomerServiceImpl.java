package com.shop.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CurrentUserRepositroy currentUserRepository;

	@Autowired
	private AdminRepositroy adminRepository;

	@Override
	public Customer registor(Customer customer) {
		Customer c = customerRepository.save(customer);
		return c;
	}

	@Override
	public Customer getCustomerById(Integer id) throws CustomerException {
		return customerRepository.findById(id)
				.orElseThrow(() -> new CustomerException("Id Value is present in database"));
	}

	@Override
	public Customer deleteCustomerAccount(Integer id, String loginKey) throws CustomerException, LoginException {

		Customer customer = null;
		CurrentUser cu = currentUserRepository.findByUuid(loginKey);
		if (cu == null)
			throw new LoginException("Login first");
		else {
			if (cu.getUserId() != id) {
				throw new CustomerException("Please Enter Corrent Customer ID");
			}
			Optional<Customer> opt = customerRepository.findById(id);
			if (opt.isEmpty()) {
				throw new CustomerException("Customer not present with id " + id);
			} else {
				customer = opt.get();
				customerRepository.delete(customer);
			}
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCustomer(String adminKey) throws AdminException, LoginException {

		List<Customer> customers = new ArrayList<>();
		CurrentUser cu = currentUserRepository.findByUuid(adminKey);
		if (cu == null)
			throw new LoginException("Login first");
		else {
			Optional<Admin> opt = adminRepository.findById(cu.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("You are not a admin");
			} else {
				customers = customerRepository.findAll();
			}
		}
		return customers;
	}

}
