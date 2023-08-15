package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;


import com.shop.repository.*;

@Service
public class SellerServiceImpl implements SellerService {

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
	PaymentRepository paymentRepository;

	@Override
	public Seller insertSeller(Seller seller) throws SellerException {
		Seller existingSeller = sellerRepository.findByEmail(seller.getEmail());

		if (existingSeller != null) {
			throw new SellerException("Seller with this Email already Exist");
		}

		Seller newSeller = sellerRepository.save(seller);

		return newSeller;
	}

	@Override
	public String deleteSeller(int sid, String Key) throws SellerException, LoginException {

		Optional<Seller> opt = sellerRepository.findById(sid);
		if (opt == null)
			throw new SellerException("Invalid Credentials...!");

		Seller seller = opt.get();

		CurrentUserSession cus = currentUserSession.findByUuid(Key);

		if (cus.getUserId() == sid) {
			throw new LoginException("Please Login First");
		}

		sellerRepository.delete(seller);

		return "We hope you enjoy our service " + seller.getSellerName();
	}

	@Override
	public Seller updateName(int sid, String key, String sellerName) throws SellerException, LoginException {

		Optional<Seller> opt = sellerRepository.findById(sid);
		if (opt == null)
			throw new SellerException("Invalid Credentials...!");

		Seller seller = opt.get();

		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus.getUserId() != sid) {
			throw new LoginException("Please Login First");
		}

		seller.setSellerName(sellerName);
		sellerRepository.save(seller);

		return seller;
	}

}
