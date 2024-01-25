package com.org.students.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Component
public class Login {
	
	String username;
	String password;
	String token;
	String message;

}
