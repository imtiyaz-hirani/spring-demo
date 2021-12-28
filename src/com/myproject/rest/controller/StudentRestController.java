package com.myproject.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.Student;
import com.myproject.service.StudentRestService;
import com.myproject.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService studentService; 
	
	@Autowired
	private StudentRestService studentRestService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	public String showHello() {
		return "Hello REST API!!"; 
	}
	
	/*
	 * gets all student record as JSON
	 */
	@RequestMapping(method=RequestMethod.GET, value="/students" ,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Student> getAllStudents() {
		List<Student> list = studentService.getStudentList(); 
		return list; 
	}
	
	/*
	 * returns single student based on ID. 
	 */
			
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/student/{id}" , 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable("id") int id) {
		Student s = studentRestService.getStudentById(id);
		return s; 
	}
	
	/*
	 * Delete the Student record based on ID. 
	 */
	
	@RequestMapping(method = RequestMethod.DELETE, value="/student/delete/{id}")
	public void deleteStudentById(@PathVariable("id") int id) {
		int status = studentRestService.deleteStudentById(id);
		if(status == 1)
			System.out.println("Record deleted...");
		else
			System.out.println("Record not deleted..");
	}
} 
