package com.org.students.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.students.helper.MyResponseStructure;

@RestControllerAdvice
public class MainExceptionHandler {

	@Autowired
	MyResponseStructure<String> response;

	@ExceptionHandler(DataAlreadyExists.class)
	public MyResponseStructure<String> handler(DataAlreadyExists exception) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Data Already Exists");
		response.setData(exception.getMessage());
		return response;
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public MyResponseStructure<String> handler(InvalidCredentialsException exception) {
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage("Invalid Credentials");
		response.setData(exception.getMessage());
		return response;
	}
}
