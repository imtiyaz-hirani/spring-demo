package com.myproject.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
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
		RowMapper<Course> rowMapper= new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rst, int rowNum) throws SQLException {
				Course c = new Course(); 
				c.setId(rst.getInt(1));
				c.setName(rst.getString(2));
				c.setCredits(rst.getDouble(3));
				c.setDepartmentId(rst.getInt(4));
				return c;
			}			
		};
		
		return jdbc.query("select * from course", rowMapper);
	}

}
