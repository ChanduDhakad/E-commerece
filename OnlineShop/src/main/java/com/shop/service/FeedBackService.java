package com.shop.service;


import java.util.List;

import com.shop.exception.*;

import com.shop.model.Feedback;

public interface FeedBackService {

	public Feedback AddFeedBack(Feedback feedback,Integer orderId,Integer customerId,String key)
	throws LoginException,CustomerException,OrderException,FeedbackException;
	
	public Feedback updateFeedback(Feedback feedback,Integer customerId,String key) 
			throws LoginException,CustomerException,FeedbackException;
	
	public String deletefeedback(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedbackException;
	
	public List<Feedback> viewAllFeedback(Integer customerId,String key)
			throws LoginException,CustomerException,FeedbackException;
	
	public Feedback viewFeedBackById(Integer feedbackId,Integer customerId,String key)
			throws LoginException,CustomerException,FeedbackException;
	
	
}