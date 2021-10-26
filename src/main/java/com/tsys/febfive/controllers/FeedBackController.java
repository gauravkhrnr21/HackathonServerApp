package com.tsys.febfive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		if(feedBack != null) {
			FeedBack newFeedBack =  feedBackService.addFeedBack(feedBack);
			if(newFeedBack != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(newFeedBack);
			}	
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(newFeedBack);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
