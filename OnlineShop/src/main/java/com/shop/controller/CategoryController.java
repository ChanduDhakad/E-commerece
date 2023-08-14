package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shop.exception.*;
import com.shop.model.Category;


import com.shop.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService  CategoryService;

	@PostMapping("/Category")
	public ResponseEntity<Category> addNewCategory(@RequestParam String key, @RequestBody Category category) throws AdminException, LoginException, CategoryException {
		Category s = CategoryService.addCategory(category, key);
		return new ResponseEntity<Category>(s, HttpStatus.CREATED);
	}
	

}
