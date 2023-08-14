package com.shop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartRepository cartRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order createOrder(Order order, Integer cartID, String userKey)
			throws OrderException, CustomerException, LoginException, CartException {

		Order newOrder = null;

		CurrentUser cu = cur.findByUuid(userKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Cart> opt = cartRepository.findById(cartID);
			if (opt.isEmpty()) {
				throw new CartException("Cart not present with id " + cartID);
			} else {

				Cart cart = opt.get();
				Customer customer = cart.getCustomer();
				if (customer == null) {
					throw new CustomerException("Customer not present with CartID " + cartID);
				} else {

					order.setOrderDate(LocalDateTime.now());
					order.setCustomer(customer);
					order.setBillingAmount(cart.getTotalAmount());
					newOrder = orderRepository.save(order);
				}

			}
			return newOrder;
		}

	}
}
