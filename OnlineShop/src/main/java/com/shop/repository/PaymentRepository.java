package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Address;
import com.shop.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
