package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Cart;

public interface CartRepositoy extends JpaRepository<Cart, Integer> {

}
