package com.tsys.febfive.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WelcomeController {

	@GetMapping("/")
	public String WelcomeMessage() {
		return "Welcome to Feb Five API";
	}	
}
