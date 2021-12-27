package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/courses-dept")
	public ModelAndView getCoursesByDepartment(@RequestParam("deptName") String deptName, ModelAndView mav) {
		List<Course> list = courseService.getCoursesByDepartment(deptName);
		mav.setViewName("course");
		mav.addObject("list", list);
		return mav; 
	}
}
