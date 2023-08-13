package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Admin;

public interface AdminRepositroy extends JpaRepository<Admin, Integer> {

	Admin findByAdminUsername(String userName);
}
