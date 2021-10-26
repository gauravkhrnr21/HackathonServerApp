package com.tsys.febfive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsys.febfive.entities.Events;

@Repository
public interface EventsRepo extends JpaRepository<Events, Integer> {
	Events findByEventId(Integer eventId);
}
