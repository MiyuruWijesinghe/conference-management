package com.devcrawlers.conference.management.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcrawlers.conference.management.model.Users;
import com.devcrawlers.conference.management.resource.JwtResponseResource;
import com.devcrawlers.conference.management.resource.LoginRequestResource;
import com.devcrawlers.conference.management.resource.MessageResponseResource;
import com.devcrawlers.conference.management.resource.SignupRequestResource;
import com.devcrawlers.conference.management.service.AuthService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	AuthService authService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestResource loginRequest) {
		JwtResponseResource jwtResponseResource = authService.authenticateUser(loginRequest);
		return new ResponseEntity<>(jwtResponseResource,HttpStatus.CREATED);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestResource signUpRequest) {
		
		Users user =  authService.registerUser(signUpRequest);
		MessageResponseResource responseMessage = new MessageResponseResource(environment.getProperty("registered.success"), Long.toString(user.getId()));
		return new ResponseEntity<>(responseMessage,HttpStatus.CREATED);
	}
}
