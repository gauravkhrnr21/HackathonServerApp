package com.tsys.febfive.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsys.febfive.dao.SubCategoryRepo;
import com.tsys.febfive.dao.UserPerferenceRepo;
import com.tsys.febfive.entities.Category;
import com.tsys.febfive.entities.SubCategory;
import com.tsys.febfive.entities.UserPreference;
import com.tsys.febfive.entities.Users;

@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryRepo subCategoryRepo;
	
	@Autowired
	private UserPerferenceRepo userCategoryRepo;

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
		boolean isAdd = Boolean.FALSE;
		for (UserPreference user : userPreference) {
			userCategoryRepo.save(user);
			isAdd = Boolean.TRUE;
		}
		return isAdd;
	}
	
	public boolean updateAllPreferenceByUserId(List<UserPreference> userPreference){
		boolean isUpdate = Boolean.FALSE;
		int result = deletePerferenceById(userPreference.get(0).getUserId());
		if(result > 0) {
			for (UserPreference user : userPreference) {
				userCategoryRepo.save(user);
				isUpdate = Boolean.TRUE;
			}
		}
		return isUpdate;
	}

	public int deletePerferenceById(int userId){
		Query query = entityManager.createNativeQuery("delete from user_preference where user_id =:user_id");
		query.setParameter("userid", userId);
		return query.executeUpdate();
	}
}
