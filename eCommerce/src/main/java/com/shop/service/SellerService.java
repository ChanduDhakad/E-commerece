package com.shop.service;

import com.shop.exception.*;

import com.shop.model.Seller;

public interface SellerService {

	public Seller insertSeller(Seller seller) throws SellerException;

	public String deleteSeller(int sid, String Key) throws SellerException, LoginException;

	public Seller updateName(int sid, String key, String sellerName) throws SellerException, LoginException;

}
