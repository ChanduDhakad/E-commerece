package com.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.model.*;

public interface ProductDTORepository extends JpaRepository<ProductDTO, Integer> {

}
