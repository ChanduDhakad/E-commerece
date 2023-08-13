package com.shop.service;

import com.shop.exception.LoginException;
import com.shop.model.LoginDTO;


public interface LoginService {	
	public String login(LoginDTO dto) throws LoginException;	
	public String logout(String key)throws LoginException;
}
