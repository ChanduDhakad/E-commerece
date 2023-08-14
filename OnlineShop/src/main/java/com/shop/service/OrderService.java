package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Order;

public interface OrderService {

	Order createOrder(Order order,Integer cartID,String userKey) throws OrderException,CustomerException,LoginException,CartException ;
}
