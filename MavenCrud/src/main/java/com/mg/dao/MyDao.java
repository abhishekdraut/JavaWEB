package com.mg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mg.entity.Student;

public interface MyDao extends JpaRepository<Student, Integer > {

	
	
}
