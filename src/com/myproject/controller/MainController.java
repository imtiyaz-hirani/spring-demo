package com.myproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
