package com.shop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public Payment cratePayment(Payment payment, Integer orderID, String userKey)
			throws PaymentException, OrderException, LoginException,CustomerException {
		Payment newPayment = null;
		CurrentUser cu = cur.findByUuid(userKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Customer> opt = customerRepository.findById(cu.getUserId());
			if (opt.isEmpty()) {
				throw new CustomerException("Customer  not present with id " + cu.getUserId());
			} else {

				Optional<Order> orderOpt = orderRepository.findById(orderID);
				if (orderOpt.isEmpty()) {
					throw new OrderException("Order not present with id " + orderID);
				} else {

					Order order = orderOpt.get();

					payment.setAmount(order.getBillingAmount());
					payment.setTimestamp(LocalDateTime.now());
					payment.setCurrency("INR");
					payment.setOrder(order);
					payment.setPaymentMethod("Successfully Paid");

					newPayment = paymentRepository.save(payment);
				}

			}
			return newPayment;
		}

	}
}