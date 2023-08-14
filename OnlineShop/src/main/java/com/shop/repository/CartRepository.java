package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
