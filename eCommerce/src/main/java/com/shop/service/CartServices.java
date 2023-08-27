package com.shop.service;

import java.util.Map;

import com.shop.exception.*;
import com.shop.model.Cart;

public interface CartServices {

	public Cart AddProductToCart(Integer productId, String key, Integer customerId)throws LoginException, CustomerException, ProductException;

	public Cart descreaseQuantityOfProduct(Integer productId, String key, Integer customerId, Integer Quantity)throws LoginException, CustomerException, ProductException, CartException;

	public Cart removeProductFromCart(Integer productId, String Key, Integer customerId)throws LoginException, CustomerException, ProductException, CartException;

	public Cart emptycart(String key, Integer customerId) throws LoginException, CustomerException, CartException;
	
	public Map<String, Integer> getAllProductInCart(Integer customerId, String key)throws LoginException, CustomerException, CartException;

	public Integer getCartValue(Integer customerId, String key) throws LoginException, CustomerException;

}