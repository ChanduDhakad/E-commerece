package com.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.exception.*;
import com.shop.model.*;
import com.shop.repository.*;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CurrentUserRepositroy cur;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category, String adminKey)
			throws LoginException, CategoryException, AdminException {
		Category newCategory = null;

		CurrentUser cu = cur.findByUuid(adminKey);
		if (cu == null) {
			throw new LoginException("Login first");
		} else {
			Optional<Admin> opt = adminRepository.findById(cu.getUserId());
			if (opt.isEmpty()) {
				throw new AdminException("Admin not present with id " + cu.getUserId());
			} else {
				newCategory = categoryRepository.save(category);
			}
		}
		return newCategory;

	}

	

}
