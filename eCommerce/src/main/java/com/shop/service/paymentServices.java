package com.shop.service;

import java.util.List;

import com.shop.exception.*;

import com.shop.model.Payment;

public interface paymentServices {

	public Payment makePayment(Integer orderId, Integer cardId, Integer customerId, String key)	throws LoginException, CustomerException, OrderException, PaymentException, CardException;

	public Payment viewPaymentDetailsById(Integer paymentId, Integer customerId, String key)throws LoginException, CustomerException, OrderException, PaymentException;

	public List<Payment> getAllPaymentByCustomer(Integer customerId, String key)throws LoginException, CustomerException, OrderException, PaymentException;

	public String cancelPayment(Integer payId, Integer customerId, String key)throws LoginException, CustomerException, OrderException, PaymentException;
}