package com.tsys.febfive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
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
	public ResponseEntity<List<Events>> getEvents() {
		List<Events> events =  eventsService.getAllEvents();
		if(!CollectionUtils.isEmpty(events)) {
			return ResponseEntity.status(HttpStatus.OK).body(events);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(path = "/addEvent", produces = "application/json")
	public ResponseEntity<Events> addEvent(@RequestBody Events event) {
		if(event != null) {
			Events newEvent = eventsService.addEvent(event);
			if(newEvent != null) {
				 return ResponseEntity.status(HttpStatus.CREATED).body(newEvent);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newEvent);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping(path = "/getEventById", produces = "application/json")
	public ResponseEntity<Events> getEventById(@RequestBody Events event) {
		if(event != null) {
			Events response = eventsService.getEventById(event);
			if(response != null) {
				 return ResponseEntity.status(HttpStatus.OK).body(response);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
