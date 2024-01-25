package com.org.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.students.dto.Student;

public interface Myrepository extends JpaRepository<Student, Integer>{

}
