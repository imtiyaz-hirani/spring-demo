package com.myproject.db;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.myproject.model.Course;

@Component
public class CourseDB {

	private NamedParameterJdbcTemplate jdbc; 
	//this jdbc has to be connected to dataSource from config 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
			jdbc = new NamedParameterJdbcTemplate(dataSource); 
	}
	 
	
	public List<Course> getAllCourses() {
		
		return null;
	}

}
