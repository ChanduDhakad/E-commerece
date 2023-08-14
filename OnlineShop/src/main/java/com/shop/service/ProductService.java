package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Product;


public interface ProductService {

	Product addNewProduct(Product product,Integer sellerID,Integer categoryID,String adminKey) throws ProductException,SellerException,CategoryException,AdminException,LoginException ;
}
