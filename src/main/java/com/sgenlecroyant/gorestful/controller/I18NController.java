package com.sgenlecroyant.gorestful.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sgenlecroyant.gorestful.model.WelcomeMessage;

@RestController
public class I18NController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(value = "/welcome")
	public WelcomeMessage getWelcomeMessage(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		String message = this.messageSource.getMessage("welcome.message", null, locale);
		WelcomeMessage welcomeMessage = new WelcomeMessage(message);
		return welcomeMessage;
	}
	

	@GetMapping(value = "/welcome-v2")
	public WelcomeMessage getWelcomeMessageV2() {
		String message = this.messageSource.getMessage("welcome.message", null, LocaleContextHolder.getLocale());
		WelcomeMessage welcomeMessage = new WelcomeMessage(message);
		return welcomeMessage;
	}
	

}
