package com.shop.service;

import java.util.List;

import com.shop.exception.AdminException;
import com.shop.exception.LoginException;
import com.shop.model.Admin;

public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;

	public Admin updateAdmin(Admin admin, String key) throws LoginException, AdminException;

	public String deleteAdmin(Integer adminId, String key) throws LoginException, AdminException;

	public Admin getAdminById(Integer adminId, String key) throws LoginException, AdminException;
}
