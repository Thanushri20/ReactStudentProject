package com.org.students.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Component
@Entity
public class StudentDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;	
String studentname;
long studentphone;
String studentemail;
int web;
int corejava;
int advancejava;
int apti;
int msql;
double percentage;
int total;
String result;
}
