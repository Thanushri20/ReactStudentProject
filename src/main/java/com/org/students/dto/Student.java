package com.org.students.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Component
@Data
@Entity
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
String username;
String password;
String token;

}
