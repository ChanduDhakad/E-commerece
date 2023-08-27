package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer>{

	 Seller findByEmail(String eamil);
}
