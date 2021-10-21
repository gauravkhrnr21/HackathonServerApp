package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tsys.febfive.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{


}
