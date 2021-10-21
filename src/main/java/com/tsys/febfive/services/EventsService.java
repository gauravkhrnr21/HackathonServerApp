package com.tsys.febfive.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsys.febfive.dao.EventsRepo;
import com.tsys.febfive.entities.Events;

@Service
public class EventsService {

	@Autowired
	private EventsRepo eventRepo;

	public List<Events> getAllCategory() {
		return eventRepo.findAll();
	}

	public void addEvent(Events evnet) {
		eventRepo.save(evnet);
	}

	public List<Events> getAllEvents() {
		return eventRepo.findAll();
	}

}
