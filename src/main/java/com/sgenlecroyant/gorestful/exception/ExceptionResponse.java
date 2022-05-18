package com.sgenlecroyant.gorestful.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	
	private Date timestamp;
	private HttpStatus httpStatus;
	private String errorMessage;
	private String details;
	
	public ExceptionResponse(Date timestamp, HttpStatus httpStatus, String errorMessage, String details) {
		this.timestamp = timestamp;
		this.httpStatus = httpStatus;
		this.errorMessage = errorMessage;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	

}
