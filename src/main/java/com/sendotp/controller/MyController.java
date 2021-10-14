package com.sendotp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sendotp.entities.User;
import com.sendotp.services.UserService;

@RestController
public class MyController {

	@Autowired
	public UserService userService;
	
	@PostMapping("/user")
	
	public ResponseEntity<User> sendOtp(@Valid @RequestBody User user) {
		User u = null;
		try {
			u = userService.sendOtp(user);
			return ResponseEntity.status(HttpStatus.OK).body(u);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(u);
		}
	}
}
