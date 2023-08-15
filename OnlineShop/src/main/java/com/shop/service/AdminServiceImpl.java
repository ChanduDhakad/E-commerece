package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shop.exception.AdminException;
import com.shop.exception.LoginException;
import com.shop.model.Admin;
import com.shop.model.CurrentUserSession;
import com.shop.repository.*;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CurrentUserRepositroy currentUserRepositroy ;

	@Override
	public Admin registerAdmin(Admin admin) throws AdminException {
		Admin newAdmin=null;
		Admin existingAdmin = adminRepository.findByUserName(admin.getUserName());
		if(existingAdmin!=null) {
			throw new AdminException("Admin already exist with username "+admin.getUserName());
		}
		newAdmin = adminRepository.save(admin);
		return newAdmin;
	}

	@Override
	public Admin updateAdmin(Admin admin, String key) throws LoginException, AdminException {
		checkLogin(key, admin.getAdminId());
		
		adminRepository.save(admin);
		
		return admin;
	}

	@Override
	public String deleteAdmin(Integer adminId, String key) throws LoginException, AdminException {
		Admin admin = checkLogin(key, adminId);
		
		adminRepository.delete(admin);
		currentUserRepositroy.delete(currentUserRepositroy.findByUuid(key));
		
		return "Admin Deleted Sucessfully";
	}

	@Override
	public Admin getAdminById(Integer adminId, String key) throws LoginException, AdminException {
		Admin admin = checkLogin(key, adminId);
		return admin;
	}

	public Admin checkLogin(String key, Integer AdminId) throws LoginException, AdminException {
		Optional<Admin> opt =adminRepository.findById(AdminId);
		if (opt.isEmpty())
			throw new AdminException("No Admin Found with id:- " + AdminId);

		Admin admin = opt.get();
		CurrentUserSession cus = currentUserRepositroy.findByUuid(key);

		if (cus == null)
			throw new LoginException("Invalid Current Key");
		if (cus.getUserId() != admin.getAdminId())
			throw new LoginException("Please Login first.....");

		return admin;

	}

}
