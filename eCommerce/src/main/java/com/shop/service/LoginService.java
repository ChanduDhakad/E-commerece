package com.shop.service;

import com.shop.exception.LoginException;
import com.shop.model.*;

public interface LoginService {

	public CurrentUserSession customerLogin(Login log) throws LoginException;

	public CurrentUserSession sellerlogin(Login log) throws LoginException;

	public String Logout(Integer id, String uuid) throws LoginException;

	public CurrentUserSession adminlogin(Login log) throws LoginException;
}
