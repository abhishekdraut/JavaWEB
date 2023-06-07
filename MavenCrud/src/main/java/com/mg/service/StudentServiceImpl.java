package com.mg.service;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.dao.MyDao;
import com.mg.dao.MyDao2;
import com.mg.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	// private List<Student> std;
	@Autowired
	private MyDao mydao;
	@Autowired
	private MyDao2 mydao2;

	public StudentServiceImpl() {
//		std=new ArrayList<Student>();
//		std.add(new Student(111,"Mahesh","Ghodekar","mahesh@gmail.com"));
//		std.add(new Student(112,"Kalpesh","Ghodekar","mahesh@gmail.com"));
//		std.add(new Student(113,"Roshan","Ghodekar","mahesh@gmail.com"));
//		std.add(new Student(114,"Shivam","Ghodekar","mahesh@gmail.com"));	
	}

	@Override
	public List<Student> getStudent() {

		return mydao.findAll();
	}
	
	@Override
	@Transactional
	public List<Student> getAllUserList() {
		return mydao2.GetAllUserList();
	}

	@Override
	public List<Student> addStudents(List<Student> Student) {
//		
//		for(Student i : Student) {
//			std.add(i);
//		}

		return mydao.saveAll(Student);
	}

	@Override
	public Student getOneStudent(int studentId) {
//		for(Student i : std) {
//			if(i.getId()==studentId) {
//				return i;
//			}
//		}

		return mydao.getReferenceById(studentId);
	}

	@Override
	public List<Student> deleteStudent(int studentId) {

//		for(Student i : std) {
//			if(i.getId()==studentId) {
//				
//				this.std.remove(i);
//				return i;
//				
//			}
//		}
		mydao.deleteById(studentId);
		return mydao.findAll();

	}

	@Override
	public List<Student> UpdateStudent(List<Student> Student) {

//		for(Student i :   Student) {
//			for(Student j : std) {
//				if(i.getId()==j.getId()) {
//					j.setName(i.getName());
//					j.setLname(i.getLname());
//					j.setEmail(i.getEmail());
//				}
//					
//				}
//			}
//		
		return mydao.saveAll(Student);
	}

	public Student getOneStudent1(int studentId) {
//		for(Student i : std) {
//			if(i.getId()==studentId) {
//				return i;
//			}
//		}

		Optional<Student> e = mydao.findById(studentId);
		Student theStudent = e.get();
		return theStudent;
	}

}
