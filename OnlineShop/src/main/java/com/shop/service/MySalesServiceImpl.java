package com.shop.service;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;


import com.shop.model.*;
import com.shop.repository.*;


@Service
public class MySalesServiceImpl implements MySalesServices{

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
	AdminRepository adminRepository;
	
	@Override
	public List<Order> SalesForToday(Integer AdminId,String key) throws AdminException, LoginException, OrderException  {
		
		 checkLogin(key, AdminId);
		
		List<Order> olist = orderRepository.findByOrderDate(LocalDate.now());
		
		if(olist.size()==0) throw new OrderException("No Order placed Today");
		
		return olist;
	}

	@Override
	public List<Order> SalesForWeek(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orderRepository.findByOrderDateBetween(LocalDate.now().minusWeeks(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForMonth(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orderRepository.findByOrderDateBetween(LocalDate.now().minusMonths(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Week");
			
		return olist;
	}

	@Override
	public List<Order> SalesForYear(Integer AdminId,String key) throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orderRepository.findByOrderDateBetween(LocalDate.now().minusYears(1), LocalDate.now());
			
			if(olist.size()==0) throw new OrderException("No Order placed in last Year");
			
		return olist;
	}

	@Override
	public List<Order> SalesBetweenDates(LocalDate l1, LocalDate l2, Integer AdminId, String key)
			throws AdminException, LoginException, OrderException {
		 checkLogin(key, AdminId);
			
			List<Order> olist =orderRepository.findByOrderDateBetween(l1, l2);
			
			if(olist.size()==0) throw new OrderException("No Order placed between "+l1+" and "+l2);
			
		return olist;
	}

	public Admin checkLogin(String key, Integer AdminId) throws LoginException, AdminException {
		Optional<Admin> opt = adminRepository.findById(AdminId);
		if (opt.isEmpty())
			throw new AdminException("No Admin Found with id:- " + AdminId);

		Admin admin = opt.get();
		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != admin.getAdminId())
			throw new LoginException("Please Login first.....");

		return admin;

	}
	
	
}