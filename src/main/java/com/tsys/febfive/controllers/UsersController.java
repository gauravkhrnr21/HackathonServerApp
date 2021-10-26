package com.tsys.febfive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tsys.febfive.entities.Users;
import com.tsys.febfive.services.UsersService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	public UsersController() {
		//System.out.println("user controller call");
	}
	
	@PostMapping(path = "/getUserByEmail", consumes = "application/json",produces = "application/json")
	public ResponseEntity<Users> getUserByEmail(@RequestBody Users user) {
		if(user != null) {
			Users users =  usersService.getUserByEmail(user.getEmail());
			if(users != null) {
				return ResponseEntity.status(HttpStatus.OK).body(users);
			}
			return ResponseEntity.status(HttpStatus.OK).body(users);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
	
	@PostMapping(path = "/setUserStatus", consumes = "application/json",produces = "application/json")
	public ResponseEntity<Users> setUserStatus(@RequestBody Users user) {
		if(user != null) {
			Users updatedUser = usersService.setUserStatus(user);
			if(updatedUser != null) {
				return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
			}
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedUser);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
}
