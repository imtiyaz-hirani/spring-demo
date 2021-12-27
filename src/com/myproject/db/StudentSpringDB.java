package com.myproject.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.myproject.model.Student;

@Component
public class StudentSpringDB {

	private NamedParameterJdbcTemplate jdbc; 
	//this jdbc has to be connected to dataSource from config 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
			jdbc = new NamedParameterJdbcTemplate(dataSource); 
	}
	 
	public Student getStudentById(int id) { //id=3
		 RowMapper<Student> rowMapper = new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rst, int rowNum) throws SQLException {
				Student s= new Student();
			    s.setId(rst.getInt(1));
				s.setName(rst.getString(2));
				s.setCity(rst.getString(3));
				s.setEmail(rst.getString(4));
				return s;
			} 
		};
		 Map<String, Integer> map = new HashMap<>(); 
		 map.put("id", id); 
		 List<Student> list = jdbc.query("select * from student where stud_id=:id", map, rowMapper);
		 if(list != null)
			 return list.get(0);
		 else
			 throw new RuntimeException("ID is Invalid");
	 
	}

}
