package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Cart;



public interface CartService {

	Cart addNewCart(Cart cart,String userKey) throws CustomerException,CartException,LoginException ;
	Cart addNewProductIntoCart(Integer cartID,Integer productID,String userKey) throws CartException,ProductException,LoginException,CustomerException ;
	
}
