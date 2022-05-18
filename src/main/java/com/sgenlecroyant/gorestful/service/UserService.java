package com.sgenlecroyant.gorestful.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgenlecroyant.gorestful.entity.User;
import com.sgenlecroyant.gorestful.exception.ResourceNotFoundException;
import com.sgenlecroyant.gorestful.repository.UserRepository;

@Service(value = "userService")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}
	
	public User fetchUserById(Integer id) {
		return this.userRepository.findById(id)
							.orElseThrow(() -> {
								return new ResourceNotFoundException("Invalid ID: " +id);
							});
	}
	
	public List<User> fetchUsers(){
		return this.userRepository.findAll();
	}
}
