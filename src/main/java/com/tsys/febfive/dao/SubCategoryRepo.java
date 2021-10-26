package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsys.febfive.entities.SubCategory;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer>{
	
	SubCategory findBySubCategoryName(String subCategoryName);
}
