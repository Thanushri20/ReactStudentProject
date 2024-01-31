package com.org.students.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.students.dto.Student;
import com.org.students.dto.StudentDetails;
import com.org.students.repository.Myrepository;

@Repository
public class Mydao {

	@Autowired
	Myrepository myrepository;
	
	

	public boolean checkUserNameExists(String username) {
		return myrepository.existsByUsername(username);
	}

	public Student findByUsername(String username) {
		return myrepository.findByUsername(username);
	}

	public Student save(Student student) {
		return myrepository.save(student);
	}

	

	

}
