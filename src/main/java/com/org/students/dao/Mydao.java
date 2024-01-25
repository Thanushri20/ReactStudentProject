package com.org.students.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.students.dto.Student;
import com.org.students.repository.Myrepository;

@Repository
public class Mydao {
	
	@Autowired
	Myrepository myrepository;

	public Student save(Student student) {
		return myrepository.save(student);
	}

	public List<Student> fetchall() {
		return myrepository.findAll();
		
	}

	public Student findbyid(int id) {
		return myrepository.findById(id).orElseThrow();
		
	}

	public List<Student> find() {
		return myrepository.findAll();
	}

}
