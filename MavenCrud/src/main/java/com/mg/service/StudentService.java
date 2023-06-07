package com.mg.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mg.entity.Student;
@Component
public interface StudentService {

	public List<Student> getStudent();
	
	public List<Student> getAllUserList();

	public List<Student> addStudents(List<Student> Student);

	public Student getOneStudent(int studentId);

	public List<Student>  deleteStudent(int studentId);

	public List<Student> UpdateStudent( List<Student> Student);
	
	
}
