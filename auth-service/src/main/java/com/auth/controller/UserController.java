package com.auth.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.auth.model.Users;
import com.auth.service.UserService;

@RestController
public class UserController {

	
	@RequestMapping("/user")
	Principal getUser(Principal principal){
		System.out.println("User name :"+principal);
		return principal;
	}

	@Autowired
	UserService userService;

	@RequestMapping(value = "/save", headers = "accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody Users user) {
		userService.save(user);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/get", headers = "accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<List<Users>> save() {
		return new ResponseEntity<List<Users>>(userService.list(), HttpStatus.OK);
	}
	
}
