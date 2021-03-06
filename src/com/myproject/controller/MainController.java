package com.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myproject.model.Student;
import com.myproject.service.StudentService;

@Controller
public class MainController {
	@Autowired
	StudentService service;
	@Autowired
	Student student;
	@Autowired
	DataSource dataSource; 
	@RequestMapping("/")
	public ModelAndView viewIndex(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("title", "Hogwards Magic School");
		mav.addObject("student", student);
		return mav;
	}
	
	@RequestMapping("/college")
	public ModelAndView viewCollege(ModelAndView mav) {
		mav.addObject("count",12);  //setting count=12 : this count is an attribute in jsp
		mav.addObject("studentName","harry potter");
		mav.addObject("title", "Hogwards Magic School");
		mav.setViewName("college");
		return mav;
	}
	
	@RequestMapping("/course")
	public String viewCourse(@RequestParam("courseName") String courseName, Model model) {
		System.out.println(courseName);
		//String courseName = request.getParameter("courseName");
		model.addAttribute("courseName", courseName);
		return "course";
	}
	
	@RequestMapping("/student")
	public String viewStudent(Model model) {
		 
		List<Student> list = service.getStudentList();//taking list from the service
		model.addAttribute("studentList", list);//pass list to jsp 
		
		//DB OPS 
		//insert : 
		Student s=new Student(11,"pippin clark", "pippin@wot.com", "mumbai");
		//service.insertStudent(s);
		
		//delete student
		/*
		int status = service.deleteStudent(11);
		if(status == 1)
			System.out.println("Student deleted successfully..");
		else
			System.out.println("Operation unsuccessfull");
			*/
		
		//fetch: select students
		
		List<Student> listDB = service.fetchStudents();
		
		for(Student stud : listDB) {
			System.out.println(stud);
		}
		return "student";
	}
	
	@RequestMapping("/add-student")
	public String addStudent(@ModelAttribute Student student,Model model) {
		service.insertStudent(student);
		List<Student> studentList = service.fetchStudents();
		model.addAttribute("studentList", studentList);
		model.addAttribute("msg", "Student with ID " + student.getId() + " registered!!!!");
		return "student"; 
	}
}
