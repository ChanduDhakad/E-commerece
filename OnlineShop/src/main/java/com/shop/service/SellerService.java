package com.shop.service;

import com.shop.exception.AdminException;
import com.shop.exception.LoginException;
import com.shop.exception.SellerException;
import com.shop.model.Seller;

public interface SellerService {

	Seller addNewSeller(Seller seller,String adminKey) throws LoginException,SellerException,AdminException ;
}
