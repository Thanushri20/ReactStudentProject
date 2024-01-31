package com.org.students.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataAlreadyExists extends RuntimeException {
	String message;

	public DataAlreadyExists(String message) {
		this.message = message;
	}
}
