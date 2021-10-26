package com.tsys.febfive.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tsys.febfive.dao.CategoryRepo;
import com.tsys.febfive.dao.SubCategoryRepo;
import com.tsys.febfive.dao.UserPerferenceRepo;
import com.tsys.febfive.entities.Category;
import com.tsys.febfive.entities.SubCategory;
import com.tsys.febfive.entities.UserPreference;
import com.tsys.febfive.entities.Users;
import com.tsys.febfive.request.SearchRequest;

@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserPerferenceRepo userPreferanceRepo;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<SubCategory> getAllSubCategory() {
		return subCategoryRepo.findAll();
	}

	public List<SubCategory> getAllSubCategoryByCategory(Category category) {
		Query query = entityManager.createNativeQuery("select * from sub_category where category_id =:categoryid ", SubCategory.class);
		query.setParameter("categoryid", category.getCategoryId());
		return query.getResultList();
	}
	
	public boolean addAllSubCategoryByCategory(List<UserPreference> userPreference) {
		boolean isAdded = Boolean.FALSE;
		for (UserPreference user : userPreference) {
			userPreferanceRepo.save(user);
			isAdded = Boolean.TRUE;
		}
		return isAdded;
	}
	
	@Transactional
	public boolean updateAllPreferenceByUserId(List<UserPreference> userPreference){
		boolean isUpdated = Boolean.FALSE;
		Integer userId = userPreference.get(0).getUserId();
		int result = userPreferanceRepo.deleteByUserId(userId);
		if(result > 0) {
			for (UserPreference user : userPreference) {
				userPreferanceRepo.save(user);
				isUpdated = Boolean.TRUE;
			}
		}
		return isUpdated;
	}
	
	public List<SubCategory> getAllUserSelectedCategory(Users users){
		Query query = entityManager.createNativeQuery("select * from sub_category where sub_category_id in (select sub_category_id from user_preference where user_id =:userid)", SubCategory.class);
		query.setParameter("userid", users.getUserId());
		return query.getResultList();
	}
	
	public List<Users> searchInterest(SearchRequest request){
		Category category = null;
		SubCategory subCategory =null;
		if(!StringUtils.isEmpty(request.getInterest())) {
			category = categoryRepo.findByCategoryName(request.getInterest());
		}
		if(!StringUtils.isEmpty(request.getSubInterest())){
			subCategory = subCategoryRepo.findBySubCategoryName(request.getSubInterest());
		}
		if(category != null || subCategory != null) {
			Query query = entityManager.createNativeQuery("select u.employee_name,u.employee_id,u.department,u.project,u.designation from user_preference p inner join user u on u.user_id = p.user_id where p.category_id =:categoryId or (p.category_id =:categoryId and p.sub_category_id =:subCategoryId)",Users.class);
			query.setParameter("categoryId", category!=null? category.getCategoryId() : null);
			query.setParameter("subCategoryId", subCategory!= null? subCategory.getSubCategoryId():null);
			return query.getResultList();
		}
		return Collections.emptyList();
	}
}
