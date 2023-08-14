package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Category;
import com.shop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
