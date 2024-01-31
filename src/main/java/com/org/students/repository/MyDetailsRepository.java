package com.org.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.students.dto.StudentDetails;

public interface MyDetailsRepository extends JpaRepository<StudentDetails, Integer>{

	StudentDetails findByStudentemail(String studentemail);

}
