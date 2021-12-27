package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.db.CourseDB;
import com.myproject.model.Course;

@Service
public class CourseService {

	@Autowired
	private CourseDB courseDb; 
	
	public List<Course> getAllCourses() {
		List<Course> list = courseDb.getAllCourses(); 
		return list;
	}

}
