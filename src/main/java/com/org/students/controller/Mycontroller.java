package com.org.students.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.students.dto.Student;
import com.org.students.dto.StudentDetails;
import com.org.students.helper.MyResponseStructure;
import com.org.students.helper.RegisterHelper;
import com.org.students.repository.Myrepository;
import com.org.students.service.Myservice;

@RestController
@CrossOrigin
public class Mycontroller {

	@Autowired
	Myservice myservice;

	@PostMapping("/students")
	public MyResponseStructure<RegisterHelper> insert(@RequestBody RegisterHelper registerHelper) {
		return myservice.save(registerHelper);
	}

	@PostMapping("/students/login")
	public MyResponseStructure<Student> login(@RequestBody RegisterHelper registerHelper) {
		return myservice.login(registerHelper);
	}
	
	@PostMapping("/students/marks")
	public MyResponseStructure<StudentDetails> details(@RequestBody StudentDetails details){
		return myservice.details(details);
	}
	
	@GetMapping("/students/details")
	public MyResponseStructure<List<StudentDetails>> fetchall(){
		return myservice.fetchall();
	}
	
	@PatchMapping("/students/edit/id/{id}")
		public MyResponseStructure<StudentDetails> update(@RequestBody StudentDetails details,@PathVariable int id) {	
			return myservice.update(details,id);
		}
	
	@DeleteMapping("/students/id/{id}")
	public MyResponseStructure<StudentDetails> delete(@PathVariable int id){
		return myservice.delete(id);
	}
    
	@GetMapping("/email/{studentemail}")
	public MyResponseStructure<StudentDetails> sentemail(@PathVariable String studentemail){
		return myservice.sentemail(studentemail);
	}
}
