package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.AdminException;
import com.shop.exception.LoginException;
import com.shop.exception.SellerException;
import com.shop.model.Address;
import com.shop.model.Admin;
import com.shop.model.CurrentUser;
import com.shop.model.Seller;
import com.shop.repository.AddressRepository;
import com.shop.repository.AdminRepository;
import com.shop.repository.CurrentUserRepositroy;
import com.shop.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	SellerRepository sellerRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	AddressRepository addressRepository;

	@Override
	public Seller addNewSeller(Seller seller, String adminKey) throws LoginException, SellerException, AdminException {

		Seller s = null;
		CurrentUser cu = cur.findByUuid(adminKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Admin> opt = adminRepository.findById(cu.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("Admin not present with id " + cu.getUserId());
			} else {
				Address address = seller.getAddress();
				Address sAddress = addressRepository.save(address);
				seller.setAddress(sAddress);
				s = sellerRepository.save(seller);
			}
		}
		return s;
	}

}
