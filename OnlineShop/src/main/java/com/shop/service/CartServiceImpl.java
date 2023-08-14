package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CartRepositoy cartRepository;

	@Autowired
	ProductRepository prodcutRepository;

	@Override
	public Cart addNewCart(Cart cart, String userKey) throws CustomerException, CartException, LoginException {

		Cart newCart = null;
		CurrentUser cu = cur.findByUuid(userKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Customer> opt = customerRepository.findById(cu.getUserId());

			if (opt.isEmpty())
				throw new CustomerException("Customer not Present with customerID " + cu.getUserId());
			else {
				Customer c = opt.get();
				cart.setCustomer(c);
				newCart = cartRepository.save(cart);
			}
		}
		return newCart;
	}

	@Override
	public Cart addNewProductIntoCart(Integer cartID, Integer productID, String userKey)
			throws CartException, ProductException, LoginException, CustomerException {
		Cart newCart = null;
		CurrentUser cu = cur.findByUuid(userKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Customer> opt = customerRepository.findById(cu.getUserId());
			if (opt.isEmpty())
				throw new CustomerException("Customer not Present with customerID " + cu.getUserId());
			else {
				Optional<Product> optProduct = prodcutRepository.findById(productID);
				if (optProduct.isEmpty())
					throw new ProductException("Product not Present with ProductID " + productID);
				else {
					Optional<Cart> optCart = cartRepository.findById(cartID);
					if (optCart.isEmpty())
						throw new CartException("Cart not Present with CartID " + cartID);
					else {
						Product product = optProduct.get();
						Cart cart = optCart.get();
						cart.getProducts().add(product);
						cart.setTotalAmount(product.getPrice());
						newCart = cartRepository.save(cart);
					}
				}

			}
		}

		return newCart;
	}

}
