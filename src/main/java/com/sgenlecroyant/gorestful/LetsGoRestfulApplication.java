package com.sgenlecroyant.gorestful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@SpringBootApplication
public class LetsGoRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetsGoRestfulApplication.class, args);
	}
}
