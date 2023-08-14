package com.shop.service;
import java.util.List;

import com.shop.exception.AdminException;
import com.shop.model.Admin;


public interface AdminService {
	public Admin registerAdmin(Admin admin) throws AdminException;
	
//	public Admin getAdminByName(String adminKey,String adminUserName) throws AdminException;
//	public Admin updateAdmin(Admin admin, String key) throws AdminException, LoginException;
//	public Admin deleteAdmin(String adminUserName, String key) throws AdminException;
//	public Admin findAdminById(Integer adminId) throws AdminException;
//	public Admin findAdminByUserName(String adminUserName, String key) throws AdminException, LoginException;
//	public List<Admin> findAllAdmin(String key) throws AdminException, LoginException;
}
