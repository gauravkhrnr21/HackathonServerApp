package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsys.febfive.entities.SubCategory;
import com.tsys.febfive.entities.UserPreference;

@Repository
public interface UserPerferenceRepo extends JpaRepository<UserPreference, Integer>{
}
