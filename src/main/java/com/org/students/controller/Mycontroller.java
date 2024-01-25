package com.org.students.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.students.dao.Mydao;
import com.org.students.dto.Login;
import com.org.students.dto.Student;
import com.org.students.helper.MyResponseStructure;
import com.org.students.service.Myservice;

import jakarta.servlet.http.HttpSession;


@RestController
@CrossOrigin
public class Mycontroller {
	
	@Autowired
	Student student;
	
	@Autowired
	Myservice myservice;
	
  @PostMapping("/registers")
  public MyResponseStructure insert(@RequestBody Student student) {
	return  myservice.save(student);
  }
  
  @GetMapping("/allstudents")
  public ResponseEntity<MyResponseStructure<List<Student>>> fetchall(){
	  return myservice.fetchall();
  }
  
  @PostMapping("/login")
  public Login login(@RequestBody Login login,ModelMap map){
	  return myservice.savelogin(login,map);
  }
  
}
