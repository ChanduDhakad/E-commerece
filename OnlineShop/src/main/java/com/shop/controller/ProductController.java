package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shop.exception.*;
import com.shop.model.Product;
import com.shop.service.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService  productService;

	@PostMapping("/product")
	public ResponseEntity<Product> addNewProduct( @RequestBody Product product,@RequestParam Integer sellerID,@RequestParam Integer categoryID,@RequestParam String key) throws AdminException, LoginException, SellerException, ProductException, CategoryException {
		Product p = productService.addNewProduct(product, sellerID,categoryID, key);
		return new ResponseEntity<Product>(p, HttpStatus.CREATED);
	}
	
	
}
