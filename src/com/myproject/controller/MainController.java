package com.myproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.model.Student;
import com.myproject.service.StudentService;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String viewIndex() {
		return "index.jsp";
	}
	
	@RequestMapping("/college")
	public String viewCollege(Model model, HttpServletRequest request) {
		model.addAttribute("count",12);  //setting count=12 : this count is an attribute in jsp
		request.setAttribute("studentName","harry potter");
		return "college.jsp";
	}
	
	@RequestMapping("/course")
	public String viewCourse(HttpServletRequest request,Model model) {
		String courseName = request.getParameter("courseName");
		model.addAttribute("courseName", courseName);
		return "course.jsp";
	}
	
	@RequestMapping("/student")
	public String viewStudent(Model model) {
		StudentService service = new StudentService();//reaching out to service
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
		return "student.jsp";
	}
}
