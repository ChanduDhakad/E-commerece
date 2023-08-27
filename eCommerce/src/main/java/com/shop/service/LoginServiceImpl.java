package com.shop.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CurrentUserRepository currentUserRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Override
	public CurrentUserSession customerLogin(Login login) throws LoginException {

		CurrentUserSession activeUser = null;
		Customer customer = customerRepository.findByEmail(login.getEmail());
		if (customer == null) {
			throw new LoginException("No Customer Found With this Email");
		} else {
			Optional<CurrentUserSession> opt = currentUserRepository.findById(customer.getCustomerId());
			if (opt.isPresent()) {
				throw new LoginException("User Already Logged In....");
			} else {

				String uuid = RandomString.make(6);
				CurrentUserSession cus = new CurrentUserSession(customer.getCustomerId(), LocalDateTime.now(), uuid);
				activeUser = currentUserRepository.save(cus);
			}
		}
		return activeUser;
	}

	@Override
	public CurrentUserSession sellerlogin(Login login) throws LoginException {

		CurrentUserSession activeSeller = null;
		Seller seller = sellerRepository.findByEmail(login.getEmail());
		if (seller == null) {
			throw new LoginException("No Seller Found With this Email");
		} else {
			Optional<CurrentUserSession> opt = currentUserRepository.findById(seller.getSellerId());
			if (opt.isPresent()) {
				throw new LoginException("Seller Already Logged In....");
			} else {

				new RandomString();
				String uuid = RandomString.make(6);
				CurrentUserSession cus = new CurrentUserSession(seller.getSellerId(), LocalDateTime.now(), uuid);
				activeSeller = currentUserRepository.save(cus);
			}
		}
		return activeSeller;

	}

	@Override
	public String Logout(Integer id, String uuid) throws LoginException {
		CurrentUserSession cus = currentUserRepository.findByUuid(uuid);

		if (cus == null)
			throw new LoginException("Invalid Uuid....");

		if (id != cus.getUserId())
			throw new LoginException("Invalid Credentials");

		currentUserRepository.delete(cus);
		return "Logged Out";
	}

	@Override
	public CurrentUserSession adminlogin(Login login) throws LoginException {
		CurrentUserSession activeAdmin = null;
		Admin admin = adminRepository.findByEmail(login.getEmail());
		if (admin == null) {
			throw new LoginException("Not Any Admin Present With EmailID " + login.getEmail());
		} else {
			Optional<CurrentUserSession> opt = currentUserRepository.findById(admin.getAdminId());
			if (opt.isPresent()) {
				throw new LoginException("Admin Already Logged In....");
			} else {
				new RandomString();
				String uuid = RandomString.make(6);
				CurrentUserSession cus = new CurrentUserSession(admin.getAdminId(), LocalDateTime.now(), uuid);
				activeAdmin = currentUserRepository.save(cus);
			}
		}
		return activeAdmin;
	}

}
