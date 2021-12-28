package com.myproject.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.College;
import com.myproject.service.CollegeService;

@RestController
public class CollegeController {
 
	@Autowired
	private CollegeService collegeService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/colleges", 
	produces = MediaType.APPLICATION_JSON_VALUE)
	public List<College> getAllColleges(){
		return collegeService.getAllColleges(); 
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/college/{id}" ,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public College getOne(@PathVariable("id") int id) {
		return collegeService.getCollege(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/college/delete/{id}")
	public void deleteCollege(@PathVariable("id") int id) {
		collegeService.deleteCollege(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/college/post")
	public void postCollege(@RequestBody College college) {
		collegeService.postCollege(college); 
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/college/update/{id}")
	public void updateCollege(@PathVariable("id") int id, @RequestBody College newCollege) {
		collegeService.updateCollege(id,newCollege);
	}
}








