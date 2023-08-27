package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.CardDetails;

public interface CardRepository extends JpaRepository<CardDetails, Integer> {

}
