package com.shop.controller;

import java.util.List;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class ProductController {

	@Autowired
	private ProductService spService;

	@PostMapping("/AddProduct")
	public ResponseEntity<Products> AddSellerProductHandler(@Valid @RequestBody Products sProduct,
			@RequestParam String key, @RequestParam Integer sellerId) throws LoginException, SellerException {

		Products savedProduct = spService.AddProduct(sProduct, key, sellerId);

		return new ResponseEntity<Products>(savedProduct, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Products>> getAllProductBySellerIDHandler(@RequestParam String key,
			@RequestParam Integer sellerId) throws ProductException, SellerException, LoginException {

		List<Products> list = spService.viewAllProductById(sellerId, key);

		return new ResponseEntity<List<Products>>(list, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getProductByID")
	public ResponseEntity<Products> getProductByProductIdHandler(@RequestParam Integer sProdcutId,
			@RequestParam String key, @RequestParam Integer sellerId)
			throws ProductException, LoginException, SellerException {

		Products product = spService.viewProductById(sProdcutId, key, sellerId);

		return new ResponseEntity<Products>(product, HttpStatus.ACCEPTED);
	}

	@GetMapping("/getByCategory")
	public ResponseEntity<List<Products>> getProductByCategoryHandler(String Category, String key, Integer sellerId)
			throws ProductException, LoginException, SellerException {

		List<Products> plist = spService.viewByCategory(Category, key, sellerId);

		return new ResponseEntity<List<Products>>(plist, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteProduct")
	public ResponseEntity<String> removeSellerProductHandler(@RequestParam Integer sproductId, @RequestParam String key,
			@RequestParam Integer sellerId) throws LoginException, SellerException, ProductException {

		String message = spService.removeSellerProduct(sproductId, key, sellerId);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

	@PutMapping("/UpdateProduct")
	public ResponseEntity<Products> UpdateProductHandler(@RequestParam Integer sellerId, @RequestParam String key,
			@RequestBody Products sProduct) throws LoginException, SellerException, ProductException {

		Products product = spService.updateProduct(sellerId, key, sProduct);

		return new ResponseEntity<Products>(product, HttpStatus.ACCEPTED);
	}

}