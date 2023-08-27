package com.shop.controller;

import javax.validation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.shop.service.*;
import com.shop.exception.*;
import com.shop.model.*;

@RestController
public class LoginController {

	@Autowired
	private LoginService lservices;

	@PostMapping("/sellerLogin")
	public ResponseEntity<CurrentUserSession> sellerLoginHandler(@Valid @RequestBody Login login)
			throws LoginException {

		CurrentUserSession cus = lservices.sellerlogin(login);

		return new ResponseEntity<CurrentUserSession>(cus, HttpStatus.ACCEPTED);

	}

	@PostMapping("/customerLogin")
	public ResponseEntity<CurrentUserSession> customerLoginHandler(@Valid @RequestBody Login login)
			throws LoginException {

		CurrentUserSession cus = lservices.customerLogin(login);

		return new ResponseEntity<CurrentUserSession>(cus, HttpStatus.ACCEPTED);

	}

	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentUserSession> adminLoginHandler(@Valid @RequestBody Login login) throws LoginException {

		CurrentUserSession cus = lservices.adminlogin(login);

		return new ResponseEntity<CurrentUserSession>(cus, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/Logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam Integer id, @RequestParam String key)
			throws LoginException {

		String message = lservices.Logout(id, key);

		return new ResponseEntity<String>(message, HttpStatus.ACCEPTED);
	}

}