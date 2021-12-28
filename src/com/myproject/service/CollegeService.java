package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.db.CollegeDB;
import com.myproject.model.College;

@Service
public class CollegeService {

	@Autowired
	private CollegeDB collegeDB; 
	
	public List<College> getAllColleges() {
		return collegeDB.getAllColleges(); 
	}

	public College getCollege(int id) {
		return collegeDB.getCollege(id);
	}

	public void deleteCollege(int id) {
		collegeDB.deleteCollege(id);
		
	}

	public void postCollege(College college) {
		collegeDB.postCollege(college); 
		
	}

	public void updateCollege(int id, College newCollege) {
		collegeDB.updateCollege(id,newCollege);
		
	}
	
	
}
