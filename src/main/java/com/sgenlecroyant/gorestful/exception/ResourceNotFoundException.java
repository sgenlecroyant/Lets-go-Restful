package com.sgenlecroyant.gorestful.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid resource ID")
public class ResourceNotFoundException extends RuntimeException{
	

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
