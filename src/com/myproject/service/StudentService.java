package com.myproject.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myproject.db.StudentDB;
import com.myproject.model.Student;

public class StudentService {

	private StudentDB db = new StudentDB(); 
	
	public List<Student> getStudentList() {
		List<Student> list = new ArrayList<>();
		//create 3 student objects
		Student s1=new Student(1,"harry potter", "harry@hogwards.com", "hogwards");
		Student s2=new Student(2,"ronal weasley", "ron@hogwards.com", "hogwards");
		Student s3=new Student(3,"hermione granger", "hermione@hogwards.com", "hogwards");
		
		//add students in list 
		list.add(s1);
		list.add(s2);
		list.add(s3); 
		
		return list;
	}

	public void insertStudent(Student s) {
		try {
			db.insertStudent(s);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}