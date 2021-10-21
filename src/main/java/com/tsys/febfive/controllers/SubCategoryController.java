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
import com.tsys.febfive.services.SubCategoryService;

@RestController
@CrossOrigin
@RequestMapping("/subCategory")
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;
	
	
	@GetMapping(path = "/getAllSubCategory" )
	public List<SubCategory> getAllSubCategory(){
		List<SubCategory> subCategories = subCategoryService.getAllSubCategory();
		return subCategories;
	}
	
	@PostMapping(path = "/getAllSubCategoryByCategory", produces = "application/json")
	public List<SubCategory> getAllSubCategoryByCategory(@RequestBody Category category){
		return subCategoryService.getAllSubCategoryByCategory(category);
	}
	
	@PostMapping(path = "/addAllSubCategoryByCategory", produces = "application/json")
	public ResponseEntity<Boolean> addAllSubCategoryByCategory(@RequestBody List<UserPreference> userPreference){
		if(!CollectionUtils.isEmpty(userPreference)) {
			Boolean result =  subCategoryService.addAllSubCategoryByCategory(userPreference);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PutMapping(path = "/updateAllPrefernenceByCategory", produces = "application/json")
	public ResponseEntity<Boolean> updateAllPreferenceByUserId(@RequestBody List<UserPreference> userPreference){
		if(!CollectionUtils.isEmpty(userPreference)) {
			Boolean result =  subCategoryService.updateAllPreferenceByUserId(userPreference);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
