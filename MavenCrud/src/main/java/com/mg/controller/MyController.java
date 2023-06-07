package com.mg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mg.entity.Student;
import com.mg.service.StudentService;

@RestController
@RequestMapping("/")
public class MyController {
	@Autowired
	private StudentService studentservice;

	@GetMapping("hello")
	public String sayHello() {
		return "Hello";
	}

	@GetMapping("students")
	public List<Student> getStudent() {
//		return studentservice.getStudent();
		return studentservice.getAllUserList();
		
	}
	@GetMapping("students/{studentId}")
	public Student getOneStudent(@PathVariable String studentId) {
		return studentservice.getOneStudent(Integer.parseInt(studentId));
		
	}
	@PostMapping("students")
	public List<Student> addStudent(@RequestBody List<Student> Student) {
		return studentservice.addStudents(Student);
	}

		@DeleteMapping("students/{studentId}")
		public List<Student>  deleteStudent(@PathVariable String studentId) {
			List<Student>  i =studentservice.deleteStudent(Integer.parseInt(studentId));
			return i;
		}

		@PutMapping("students")
		public List<Student> UpdateStudent(@RequestBody List<Student> Student) {
			
			return studentservice.UpdateStudent(Student);
		}

	
}
