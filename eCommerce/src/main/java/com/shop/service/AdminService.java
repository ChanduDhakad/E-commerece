package com.shop.service;

import com.shop.exception.*;
import com.shop.model.Admin;

public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;

	public Admin updateAdmin(Admin admin, String key) throws LoginException, AdminException;

	public String deleteAdmin(Integer adminId, String key) throws LoginException, AdminException;

	public Admin getAdminById(Integer adminId, String key) throws LoginException, AdminException;
}
