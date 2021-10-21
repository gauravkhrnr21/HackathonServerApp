package com.tsys.febfive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.febfive.entities.Category;
import com.tsys.febfive.entities.Users;
import com.tsys.febfive.services.CategoryService;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(path = "/getAllCategory", produces = "application/json" )
	public ResponseEntity<List<Category>> getAllCategory(){
		List<Category> categories = categoryService.getAllCategory();
		return ResponseEntity.status(200).body(categories);
	}
	
	@PostMapping(path = "/getAllCategoryById", produces = "application/json" )
	public ResponseEntity<List<Category>> getAllCategoryByUserId(@RequestBody Users users){
		List<Category> categories = categoryService.getAllCategoryByUserId(users);
		return ResponseEntity.status(200).body(categories);
	}
}
