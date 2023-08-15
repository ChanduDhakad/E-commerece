
package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;

import com.shop.repository.*;
import com.shop.*;


@Service
public class FeedBackServicesImpl implements FeedBackService {

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
	@Override
	public Feedback AddFeedBack(Feedback feedback, Integer orderId, Integer customerId, String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {
		Customer customer = checkLogin(key, customerId);

		Optional<Order> opt = orderRepository.findById(orderId);

		if (opt.isEmpty())
			throw new OrderException("Invalid Order Id");
		Order order = opt.get();

		feedback.setCustomer(customer);
		feedback.setOrder(order);

		Feedback savedfeedBack = feedbackRepository.save(feedback);

		return savedfeedBack;
	}

	@Override
	public Feedback updateFeedback(Feedback feedback, Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		checkLogin(key, customerId);

		Optional<Feedback> opt = feedbackRepository.findById(feedback.getFeedBackId());
		if (opt.isEmpty())
			throw new FeedbackException("Invalid FeedBack Id");

		Feedback existingfeed =opt.get();
		
		feedback.setCustomer(existingfeed.getCustomer());
		feedback.setOrder(existingfeed.getOrder());
		Feedback feed = feedbackRepository.save(feedback);

		return feed;
	}

	@Override
	public String deletefeedback(Integer feedbackId, Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		checkLogin(key, customerId);

		Optional<Feedback> opt = feedbackRepository.findById(feedbackId);
		if (opt.isEmpty())
			throw new FeedbackException("Invalid FeedBack Id");
		
		Feedback feed = opt.get();
		
		feedbackRepository.delete(feed);
		return "FeedBack Deleted Sucessfully....";
	}

	@Override
	public List<Feedback> viewAllFeedback(Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		Customer customer = checkLogin(key, customerId);
		
		List<Feedback> fblist = feedbackRepository.findByCustomer(customer);
		
		if(fblist.size()==0) throw new FeedbackException("No FeedBack Added yet");
		
		return fblist;
	}

	@Override
	public Feedback viewFeedBackById(Integer feedbackId, Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		Customer customer = checkLogin(key, customerId);
		
		Optional<Feedback> opt = feedbackRepository.findById(feedbackId);
		
		if(opt.isEmpty()) throw new FeedbackException("Invalid FeedBack ID");
		
		Feedback feed = opt.get();
		
		if(feed.getCustomer().getCustomerId()!=customer.getCustomerId()) {
			throw new FeedbackException("Invalid feedBack Id for customer : "+customer.getFirstName());
		}
		
		return feed;
	}
	
	
	public Customer checkLogin(String key, Integer customerId) throws LoginException, CustomerException {
		Optional<Customer> opt = customerRepository.findById(customerId);
		if (opt.isEmpty())
			throw new CustomerException("No customer Found with id:- " + customerId);

		Customer customer = opt.get();
		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != customer.getCustomerId())
			throw new LoginException("Please Login first.....");

		return customer;

	}

	
}
