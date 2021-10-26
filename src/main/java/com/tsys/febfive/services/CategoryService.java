package com.tsys.febfive.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;
import com.tsys.febfive.dao.CategoryRepo;
import com.tsys.febfive.dao.UserPerferenceRepo;
import com.tsys.febfive.entities.Category;
import com.tsys.febfive.entities.SubCategory;
import com.tsys.febfive.entities.Users;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserPerferenceRepo userPerferenceRepo;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Category> getAllCategory(){
		return categoryRepo.findAll();
	}
	
	public List<Category> getAllCategory(String userId){
		return categoryRepo.findAll();
	}
	
	public List<Category> getAllCategoryByUserId(Users users){
		Query query = entityManager.createNativeQuery("select * from category where category_id in ( select distinct(category_id) from user_preference where user_id =:userid)", Category.class);
		query.setParameter("userid", users.getUserId());
		return query.getResultList();
	}
}
