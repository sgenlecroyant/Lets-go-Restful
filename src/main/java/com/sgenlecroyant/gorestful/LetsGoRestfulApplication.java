package com.sgenlecroyant.gorestful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sgenlecroyant.gorestful.entity.User;
import com.sgenlecroyant.gorestful.repository.UserRepository;

@SpringBootApplication
public class LetsGoRestfulApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(LetsGoRestfulApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		
		User defaultUser = new User("James", "Bakana", "jamesbak@gmail.com", "password here");
		return (args) -> {
			 this.userRepository.save(defaultUser);
		};
	}
}
