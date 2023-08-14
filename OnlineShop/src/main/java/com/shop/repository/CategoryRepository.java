package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
