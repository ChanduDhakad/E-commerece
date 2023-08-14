package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Payment;



public interface PaymentService {

	Payment  cratePayment(Payment payment,Integer orderID,String userKey) throws PaymentException,OrderException,LoginException,CustomerException ;
}
