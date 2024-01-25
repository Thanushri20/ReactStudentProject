package com.org.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.org.students.dao.Mydao;

import com.org.students.dto.Login;
import com.org.students.dto.Student;
import com.org.students.helper.MyResponseStructure;

import jakarta.servlet.http.HttpSession;

@Service
public class Myservice {

	@Autowired
	Mydao mydao;

	@Autowired
	MyResponseStructure<Student> structure;

	@Autowired
	MyResponseStructure<List<Student>> structure1;

	public MyResponseStructure save(Student student) {
		student.setToken(student.getUsername() + "" + student.getPassword());
		structure.setData(mydao.save(student));
		structure.setMessage("Data Saved ");
		structure.setStatus(HttpStatus.CREATED.value());

		return structure;
	}

	public ResponseEntity<MyResponseStructure<List<Student>>> fetchall() {
		List<Student> students = mydao.fetchall();
		structure1.setData(students);
		structure1.setMessage("Data found");
		structure1.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<MyResponseStructure<List<Student>>>(structure1, HttpStatus.FOUND);
	}

	public MyResponseStructure<Student> findbyid(int id, HttpSession session, String username, String password,
			ModelMap map) {
		Student student = mydao.findbyid(id);
		if (student.getUsername().equals(username) && student.getPassword().equals(password)) {
			session.setAttribute("successMessage", "Account Created Success");
			return structure;

		} else {
			map.put("fail", "invalid credentials");
			return structure;
		}

	}

	

	public Login savelogin(Login login, ModelMap map) {
		login.setToken(login.getUsername() + "" + login.getPassword());
		List<Student> students = mydao.find();
		System.out.println("*************1");
		for (Student student : students) {
			if (student.getUsername().equals(login.getUsername())
					&& student.getPassword().equals(login.getPassword())) {

				login.setMessage("success");
				return login;

			}
		}
		login.setUsername(null);
		login.setPassword(null);
		login.setToken(null);
		login.setMessage("fail");
		return login;
	}
}
