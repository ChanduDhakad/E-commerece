package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
