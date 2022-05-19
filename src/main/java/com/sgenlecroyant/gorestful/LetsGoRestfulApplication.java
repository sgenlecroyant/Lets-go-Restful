package com.sgenlecroyant.gorestful;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

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
	
//	@Bean
	public LocaleResolver getLocaleResolver() {
		SessionLocaleResolver sessionLocaleResolver = 
				new SessionLocaleResolver();
		sessionLocaleResolver.setDefaultLocale(Locale.US);
		return sessionLocaleResolver;
	}
	
	@Bean
	public LocaleResolver getAcceptHeaderLocaleResolver() {
		AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = 
				new AcceptHeaderLocaleResolver();
		acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);
		return acceptHeaderLocaleResolver;
	}
	
//	@Bean("messageSource")
	@Bean
	public ResourceBundleMessageSource getMessageSource() {
		ResourceBundleMessageSource bundleMessageSource = 
				new ResourceBundleMessageSource();
		bundleMessageSource.setBasename("messages");
		return bundleMessageSource;
	}
}
