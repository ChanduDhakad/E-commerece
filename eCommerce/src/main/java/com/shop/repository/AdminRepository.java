package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	Admin findByUserName(String userName);
	Admin findByEmail(String email);
}
