package com.shop.service;

import java.util.List;

import com.shop.exception.*;
import com.shop.model.Order;

public interface OrderService {

	public Order placeOrder(Integer customerId, String key)	throws LoginException, CustomerException, OrderException, CartException, AddressException;

	public Order getOrderById(Integer orderId, Integer customerId, String key)throws LoginException, CustomerException, OrderException;

	public List<Order> getAllOrder(Integer customerId, String key)throws LoginException, CustomerException, OrderException;

	public String cancelOrder(Integer orderId, Integer customerId, String key)throws LoginException, CustomerException, OrderException;

	public String deleteOrder(Integer orderId, Integer customerId, String key)throws LoginException, CustomerException, OrderException;
}
