package com.tsys.febfive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsys.febfive.entities.Events;
import com.tsys.febfive.services.EventsService;

@RestController
@CrossOrigin
@RequestMapping("/events")
public class EventsController {

	@Autowired
	private EventsService eventsService;
	
	@GetMapping(path = "/getEvents", produces = "application/json")
	public List<Events> getEvents() {
		return eventsService.getAllEvents();
	}
	
	@PostMapping(path = "/addEvent", produces = "application/json")
	public void addEvent(@RequestBody Events event) {
		eventsService.addEvent(event);
	}
}
