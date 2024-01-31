package com.org.students.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.students.dto.StudentDetails;
import com.org.students.repository.MyDetailsRepository;

@Component
public class MyDetailsDao {

	@Autowired
	MyDetailsRepository detailsRepository;

	public StudentDetails savedetails(StudentDetails details) {
		return detailsRepository.save(details);
	}

	public List<StudentDetails> fetchall() {
		return detailsRepository.findAll();
	}

	public StudentDetails fetchbyid(int id) {
        return detailsRepository.findById(id).orElseThrow();
	}

	public void deleteById(int id) {
		detailsRepository.deleteById(id);
		
	}

	public StudentDetails fetchByEmail(String studentemail) {
		return detailsRepository.findByStudentemail(studentemail);
	}

	
	
}
