package com.tsys.febfive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.febfive.entities.FeedBack;
import com.tsys.febfive.services.FeedBackService;

@RestController
@CrossOrigin
@RequestMapping("/feedback")
public class FeedBackController {
	
	@Autowired
	private FeedBackService feedBackService;
	
	@PostMapping(path = "/addFeedback", produces = "application/json")
	public ResponseEntity<FeedBack> addFeedback(@RequestBody FeedBack feedBack) {
		FeedBack feedBacks =  feedBackService.addFeedBack(feedBack);
		return ResponseEntity.status(200).body(feedBacks);
	}
}
