package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.model.Course;
import com.myproject.service.CourseService;

@Controller
public class RestController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public String viewCourses(Model model) {
		
		//Go to service and fetch all the student data from the DB using Spring-JDBC
		List<Course> list = courseService.getAllCourses();
		model.addAttribute("list", list); 
		System.out.println(list);
		return "course"; 
	}
}
