package com.shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.exception.LoginException;
import com.shop.model.Login;
import com.shop.service.LoginService;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.service.*;

@RestController
public class LoginController {

	@Autowired
	private LoginService lservices;
	
	@PostMapping("/sellerLogin")
	public ResponseEntity<CurrentUserSession> sellerLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cus= lservices.sellerlogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cus,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/customerLogin")
	public ResponseEntity<CurrentUserSession> customerLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cus= lservices.customerLogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cus,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/adminLogin")
	public ResponseEntity<CurrentUserSession> adminLoginHandler(@Valid @RequestBody Login login) throws LoginException{
		
		CurrentUserSession cus= lservices.adminlogin(login);
		
		return new ResponseEntity<CurrentUserSession>(cus,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/Logout")
	public ResponseEntity<String> LogoutHandler(@RequestParam Integer id,@RequestParam String key) throws LoginException{
		
		String message= lservices.Logout(id, key);
		
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
}