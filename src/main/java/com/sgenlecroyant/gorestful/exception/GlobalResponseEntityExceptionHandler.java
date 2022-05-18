package com.sgenlecroyant.gorestful.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleGeneralException(Exception exception, WebRequest webRequest) {

		ExceptionResponse response = new ExceptionResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR,
				exception.getMessage(), webRequest.getDescription(false));

		return new ResponseEntity<ExceptionResponse>(response, response.getHttpStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		Map<String, Object> fieldErrorsMap = new HashMap<>();
		List<FieldError> fieldErrors = ex.getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		int i = 0;
		Map<Object,Object> rejected = new HashMap<>();
		while(i <fieldErrors.size()) {
			Object rejectedValue =fieldErrors.get(i).getRejectedValue();
			String rejectedField = fieldErrors.get(i).getField();
			rejected.put(rejectedField, rejectedValue);
			i++;
		}
		
		fieldErrorsMap.put("rejected", rejected);
		return new ResponseEntity<Object>(fieldErrorsMap, HttpStatus.BAD_REQUEST);
	}

}
