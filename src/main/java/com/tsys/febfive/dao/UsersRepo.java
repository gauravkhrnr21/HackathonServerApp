package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsys.febfive.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

}
