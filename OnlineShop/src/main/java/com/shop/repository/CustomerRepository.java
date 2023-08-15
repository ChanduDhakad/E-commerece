package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {



	Customer findByEmail(String email);
}
