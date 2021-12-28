package com.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.db.StudentSpringDB;
import com.myproject.model.Student;

@Service
public class StudentRestService {

	@Autowired
	private StudentSpringDB studentSpringDB;
	
	public Student getStudentById(int id) {
		 
		return studentSpringDB.getStudentById(id);
	}

	public int deleteStudentById(int id) {
		 
		return studentSpringDB.deleteStudentById(id);
	}

	public void postStudent(Student student) {
		
		studentSpringDB.postStudent(student); 
		
	}

	public int updateStudent(int id, Student studentNew) {
		
		return studentSpringDB.updateStudent(id,studentNew);
	}

}
