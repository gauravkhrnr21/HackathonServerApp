package com.tsys.febfive.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.febfive.entities.Category;
import com.tsys.febfive.entities.SubCategory;
import com.tsys.febfive.entities.UserPreference;
import com.tsys.febfive.entities.Users;
import com.tsys.febfive.request.SearchRequest;
import com.tsys.febfive.services.SubCategoryService;

@RestController
@CrossOrigin
@RequestMapping("/subCategory")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	
	@GetMapping(path = "/getAllSubCategory" )
	public ResponseEntity<List<SubCategory>> getAllSubCategory(){
		List<SubCategory> subCategories = subCategoryService.getAllSubCategory();
		if(!CollectionUtils.isEmpty(subCategories)) {
			return ResponseEntity.status(HttpStatus.OK).body(subCategories);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(subCategories);
	}
	
	@PostMapping(path = "/getAllSubCategoryByCategory", produces = "application/json")
	public ResponseEntity<List<SubCategory>> getAllSubCategoryByCategory(@RequestBody Category category){
		if(category != null) {
			List<SubCategory> subCategories =  subCategoryService.getAllSubCategoryByCategory(category);
			if(!CollectionUtils.isEmpty(subCategories)) {
				return ResponseEntity.status(HttpStatus.OK).body(subCategories);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(subCategories);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping(path = "/addAllSubCategoryByCategory", produces = "application/json")
	public ResponseEntity<Boolean> addAllSubCategoryByCategory(@RequestBody List<UserPreference> userPreference){
		if(!CollectionUtils.isEmpty(userPreference)) {
			Boolean response =  subCategoryService.addAllSubCategoryByCategory(userPreference);
			if(response) {
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
	}
	
	@PutMapping(path = "/updateAllPrefernenceByCategory", produces = "application/json")
	public ResponseEntity<Boolean> updateAllPreferenceByUserId(@RequestBody List<UserPreference> userPreference){
		if(!CollectionUtils.isEmpty(userPreference)) {
			Boolean response =  subCategoryService.updateAllPreferenceByUserId(userPreference);
			if(response) {
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Boolean.FALSE);
	}
	
	
	@PostMapping(path = "/getAllUserSelectedCategory", produces = "application/json")
	public ResponseEntity<List<SubCategory>> getAllUserSelectedCategory(@RequestBody Users users){
		if(users != null) {
			List<SubCategory> subCategories =  subCategoryService.getAllUserSelectedCategory(users);
			if(!CollectionUtils.isEmpty(subCategories)) {
				return ResponseEntity.status(HttpStatus.OK).body(subCategories);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(subCategories);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping(path = "/searchInterest", produces = "application/json")
	public ResponseEntity<List<Users>> searchInterest(@RequestBody SearchRequest request ){
		if(request != null) {
			List<Users> users =  subCategoryService.searchInterest(request);
			if(!CollectionUtils.isEmpty(users)) {
				return ResponseEntity.status(HttpStatus.OK).body(users);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(users);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
