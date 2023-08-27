package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.*;

public interface ProductRepository extends JpaRepository<Products, Integer> {

	List<Products> findByCategory(String category);

}
