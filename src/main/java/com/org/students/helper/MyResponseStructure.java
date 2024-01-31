package com.org.students.helper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class MyResponseStructure<T> {
	String message;
	int status;
	T data;
}
