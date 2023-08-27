package com.shop.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.*;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByCustomer(Customer customer);

	public List<Order> findByOrderDate(LocalDate orderDate);

	public List<Order> findByOrderDateBetween(LocalDate s_orderDate, LocalDate e_orderDate);

	public List<Order> findByOrderDateGreaterThanEqual(LocalDate orderDate);
}
