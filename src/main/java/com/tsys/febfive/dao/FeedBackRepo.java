package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsys.febfive.entities.Events;
import com.tsys.febfive.entities.FeedBack;

@Repository
public interface FeedBackRepo extends JpaRepository<FeedBack, Integer> {

}
