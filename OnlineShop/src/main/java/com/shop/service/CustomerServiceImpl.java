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
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductRepository prodcutRepository;

	@Autowired
	CurrentUserRepositroy currentUserRepositroy;

	@Autowired
	CardRepository cardRepositroy;

	@Autowired
	CartRepository cartRepositroy;

	@Autowired
	CurrentUserRepositroy currentUserSession;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	AddressRepository   addressRepository;
	
	
	
	
	
	
	@Autowired
	PaymentRepository paymentRepository;

	
	
	@Override
	public Customer AddCustomer(Customer customer) throws CustomerException {
		Customer cust = customerRepository.findByEmail(customer.getEmail());
		
		if(cust!=null) throw new CustomerException("Customer with this Email already Exist");
		
		Cart cart=new Cart();
		cart.setCartValue(0);
		cart.setProducts(new HashMap<Products,Integer>());
		
		customer.setCart(cart);
		cart.setCustomer(customer);
		Customer newCustomer=customerRepository.save(customer);
		return newCustomer;
	}

	@Override
	public Customer updateCustomer(String key, Customer customer) throws CustomerException, LoginException {
		
		Optional<Customer> opt= customerRepository.findById(customer.getCustomerId());
		
		if(opt.isEmpty()) throw new CustomerException("Invalid Credentials...."); 
		
		if(customerRepository.findByEmail(customer.getEmail())==null) 
			throw new CustomerException("Invalid Email Id");
		
		CurrentUserSession cus= currentUserSession.findByUuid(key);
		if(cus==null) throw new LoginException("Please Login First");
		
		Customer cust= opt.get();
		customer.setCard(cust.getCard());
		customer.setAddress(cust.getAddress());
		customer.setOrderList(cust.getOrderList());
		customer.setCart(cust.getCart());
		
		customerRepository.save(customer);
		return cust;
	}

	@Override
	public String deleteCustomer(Integer customerId, String key) throws CustomerException, LoginException {
		CurrentUserSession cus= currentUserSession.findByUuid(key);
		if(cus==null) throw new LoginException("Please Login First");
		
		if(customerId!=cus.getUserId()) throw new CustomerException("Invalid Credentials....");
		  
		 Customer cust =customerRepository.findById(customerId).get();
		 
		 deletefeedback(cust);
		 
		 customerRepository.delete(cust);
		
		currentUserRepositroy.delete(cus);
		
		return "Thank You for Using Our Service "+cust.getFirstName();
	}

	@Override
	public Address AddAddress(AddressDTO address, String key, Integer customerId)
			throws CustomerException, LoginException {
		
		  CurrentUserSession cus= currentUserSession.findByUuid(key);
		
		  if(cus==null) throw new LoginException("Enter Valid Key");
		  
		 Optional<Customer> opt=  customerRepository.findById(customerId);
		  
		 if(opt.isPresent()) {
			 
			 Customer cust= opt.get();
			 
			 Address add = new Address(address.getStreetNo(), address.getBuildingName(),
					 address.getCity(), address.getState(),
					 address.getCountry(), address.getPincode());
			 
			 Address addr= addressRepository.save(add);
			 cust.setAddress(addr);
			 			 
			 customerRepository.save(cust);
			 
			 return addr;
			 
		 }else {
			 throw new CustomerException("Invalid Customer Id");
		 }
	}

	public void deletefeedback(Customer cust) {
		List<Feedback> list = feedbackRepository.findByCustomer(cust);
		
		for(Feedback f:list) {
			feedbackRepository.delete(f);
		}
		
	}
}
