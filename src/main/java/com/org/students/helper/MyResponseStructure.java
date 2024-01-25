package com.org.students.helper;

import org.springframework.stereotype.Component;

import com.org.students.dto.Student;

import lombok.Data;

@Component
@Data
public class MyResponseStructure<T> {
	String message;
	int status;
	T data;
}
