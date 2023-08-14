package com.shop.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.LoginException;
import com.shop.model.*;
import com.shop.repository.*;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminRepositroy adminRepository;

	@Autowired
	private CurrentUserRepositroy currentUserRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String login(LoginDTO dto) throws LoginException {

		Admin admin = adminRepository.findByUserName(dto.getUsername());
		Customer customer = customerRepository.findByUserName(dto.getUsername());
		System.out.println("Custoemr " + customer);
		if (admin != null && customer == null) {
			Optional<CurrentUser> cu = currentUserRepository.findById(admin.getAdminId());
			if (cu.isPresent()) {
				throw new LoginException("already loggedIn");
			}
			if (admin.getPassword().equals(dto.getPassword())) {
				RandomString rs = new RandomString();
				String key = rs.make(6);
				CurrentUser newCurrentUser = new CurrentUser(admin.getAdminId(), key, true, LocalDateTime.now());
				currentUserRepository.save(newCurrentUser);
				return newCurrentUser.toString();
			}
			throw new LoginException("Please enter a valid password");

		} else if ((admin == null) && (customer != null)) {

			System.out.println("Insise Custsomer block ");
			Optional<CurrentUser> cu = currentUserRepository.findById(customer.getCustomerID());
			if (cu.isPresent()) {
				throw new LoginException("already loggedIn");
			}
			if (customer.getPassword().equals(dto.getPassword())) {
				RandomString rs = new RandomString();
				String key = rs.make(6);
				CurrentUser newCurrentUser = new CurrentUser(customer.getCustomerID(), key, false, LocalDateTime.now());
				currentUserRepository.save(newCurrentUser);
				return newCurrentUser.toString();
			}
			throw new LoginException("Please enter a valid password");
		} else {
			throw new LoginException("Please enter a valid username");
		}
	}

	@Override
	public String logout(String key) throws LoginException {
		CurrentUser cu = currentUserRepository.findByUuid(key);
		if (cu == null) {
			throw new LoginException("User not loggedin with this username");
		}
		currentUserRepository.delete(cu);
		return "Loggedout";
	}

}
