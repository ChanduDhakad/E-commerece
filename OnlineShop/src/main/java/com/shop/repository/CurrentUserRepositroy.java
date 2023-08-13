package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.shop.model.CurrentUser;




@Repository
public interface CurrentUserRepositroy extends JpaRepository<CurrentUser, Integer> {
	
	public CurrentUser findByUuid(String uuid);


}
