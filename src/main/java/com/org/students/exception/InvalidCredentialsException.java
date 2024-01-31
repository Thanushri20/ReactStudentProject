package com.org.students.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InvalidCredentialsException extends RuntimeException {
	String message;

	public InvalidCredentialsException(String message) {
		this.message = message;
	}
}
