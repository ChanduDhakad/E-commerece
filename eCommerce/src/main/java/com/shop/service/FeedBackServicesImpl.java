
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
public class FeedBackServicesImpl implements FeedBackService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CurrentUserRepository currentUserRepositroy;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public Feedback AddFeedBack(FeedbackDTO feedback, Integer orderId, Integer customerId, String key)
			throws LoginException, CustomerException, OrderException, FeedbackException {
		Customer customer = checkLogin(key, customerId);

		Optional<Order> opt = orderRepository.findById(orderId);

		if (opt.isEmpty())
			throw new OrderException("Invalid Order Id");
		Order order = opt.get();

		Feedback fb = new Feedback();
		fb.setCustomer(customer);
		fb.setLocaldate(LocalDate.now());
		fb.setMessage(feedback.getMessage());
		fb.setOrder(order);
		fb.setOverallRating(feedback.getOverallRating());
		fb.setProductRating(feedback.getProductRating());
		fb.setServiceRating(feedback.getServiceRating());

		Feedback savedfeedBack = feedbackRepository.save(fb);

		return savedfeedBack;
	}

	@Override
	public Feedback updateFeedback(FeedbackDTO feedback, Integer feedbackId, Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		checkLogin(key, customerId);

		Optional<Feedback> opt = feedbackRepository.findById(feedbackId);
		if (opt.isEmpty())
			throw new FeedbackException("Invalid FeedBack Id");

		Feedback fb = opt.get();

		fb.setLocaldate(LocalDate.now());
		fb.setMessage(feedback.getMessage());

		fb.setOverallRating(feedback.getOverallRating());
		fb.setProductRating(feedback.getProductRating());
		fb.setServiceRating(feedback.getServiceRating());

		Feedback savedfeedBack = feedbackRepository.save(fb);

		return savedfeedBack;
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

		if (fblist.size() == 0)
			throw new FeedbackException("No FeedBack Added yet");

		return fblist;
	}

	@Override
	public Feedback viewFeedBackById(Integer feedbackId, Integer customerId, String key)
			throws LoginException, CustomerException, FeedbackException {
		Customer customer = checkLogin(key, customerId);

		Optional<Feedback> opt = feedbackRepository.findById(feedbackId);

		if (opt.isEmpty())
			throw new FeedbackException("Invalid FeedBack ID");

		Feedback feed = opt.get();

		if (feed.getCustomer().getCustomerId() != customer.getCustomerId()) {
			throw new FeedbackException("Invalid feedBack Id for customer : " + customer.getFirstName());
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
