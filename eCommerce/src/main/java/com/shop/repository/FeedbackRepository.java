package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shop.model.Customer;
import com.shop.model.Feedback;
import com.shop.model.Order;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	public List<Feedback> findByCustomer(Customer customer);
	
	public List<Feedback> findByOrder(Order order);
}
