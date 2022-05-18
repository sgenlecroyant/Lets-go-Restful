package com.sgenlecroyant.gorestful.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleGeneralException(Exception exception, WebRequest webRequest){
		
		ExceptionResponse response = 
				new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), webRequest.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse>(response, response.getHttpStatus());
	}
}
