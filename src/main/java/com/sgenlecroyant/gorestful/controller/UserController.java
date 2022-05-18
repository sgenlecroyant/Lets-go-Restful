package com.sgenlecroyant.gorestful.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sgenlecroyant.gorestful.entity.User;
import com.sgenlecroyant.gorestful.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/users")
	private ResponseEntity<User> saveUser(@Valid @RequestBody(required = true) User user) {
		
		User savedUser = this.userService.saveUser(user);
		URI localtion = ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(user.getId())
							.toUri();
		return ResponseEntity
				.created(localtion)
				.body(savedUser);
				
	}
	
	@GetMapping(value = "/users/{id}")
	private ResponseEntity<User> fetchUserId(@PathVariable Integer id){
		return new ResponseEntity<User>(
				this.userService.fetchUserById(id), HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/users")
	private ResponseEntity<List<User>> fetchUsers(){
		return new ResponseEntity<List<User>>(this.userService.fetchUsers(), HttpStatus.OK);
	}
	
}
