package com.tsys.febfive.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserPreference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer userPreferenceId;
	
	private Integer userId;
	
	@Column(unique = true, nullable = false)
	private Integer subCategoryId;
	
	private Integer categoryId;
	
	public UserPreference() {}

	public UserPreference(Integer userPreferenceId, Integer userId, Integer subCategoryId) {
		super();
		this.userPreferenceId = userPreferenceId;
		this.userId = userId;
		this.subCategoryId = subCategoryId;
	}


	public Integer getUserPreferenceId() {
		return userPreferenceId;
	}


	public void setUserPreferenceId(Integer userPreferenceId) {
		this.userPreferenceId = userPreferenceId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((subCategoryId == null) ? 0 : subCategoryId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userPreferenceId == null) ? 0 : userPreferenceId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPreference other = (UserPreference) obj;
		if (subCategoryId == null) {
			if (other.subCategoryId != null)
				return false;
		} else if (!subCategoryId.equals(other.subCategoryId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userPreferenceId == null) {
			if (other.userPreferenceId != null)
				return false;
		} else if (!userPreferenceId.equals(other.userPreferenceId))
			return false;
		return true;
	}

	
	

	
}
