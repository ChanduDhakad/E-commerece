package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Product addNewProduct(Product product, Integer sellerID, Integer categoryID, String adminKey)
			throws ProductException, SellerException, CategoryException, AdminException, LoginException {
		Product newProduct = null;
		CurrentUser cu = cur.findByUuid(adminKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Admin> opt = adminRepository.findById(cu.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("Admin not present with id " + cu.getUserId());
			} else {
				Seller seller = sellerRepository.findById(sellerID)
						.orElseThrow(() -> new SellerException("Seller is not present with SellerID " + sellerID));
				Category category = categoryRepository.findById(categoryID).orElseThrow(
						() -> new CategoryException("category is not present with CategoryID " + categoryID));
				product.setCategory(category);
				product.setSeller(seller);
				newProduct = productRepository.save(product);
			}
		}
		return newProduct;
	}

}
