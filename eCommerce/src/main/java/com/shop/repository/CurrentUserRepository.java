package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.shop.model.CurrentUserSession;




@Repository
public interface CurrentUserRepository extends JpaRepository<CurrentUserSession, Integer> {
	
	public CurrentUserSession findByUuid(String uuid);


}
