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

import com.myproject.model.College;

@Component
public class CollegeDB {

	private NamedParameterJdbcTemplate jdbc; 
	//this jdbc has to be connected to dataSource from config 
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
			jdbc = new NamedParameterJdbcTemplate(dataSource); 
	}
	
	public List<College> getAllColleges() {
		RowMapper<College>  rowMapper = new RowMapper<College>() {

			@Override
			public College mapRow(ResultSet rst, int rowNum) throws SQLException {
				 College c = new College();
				 c.setId(rst.getInt(1));
				 c.setName(rst.getString(2));
				 c.setCity(rst.getString(3));
				return c;
			}
		};
		
		return jdbc.query("select * from college", rowMapper);
	}

	public College getCollege(int id) {
		
		RowMapper<College>  rowMapper = new RowMapper<College>() {

			@Override
			public College mapRow(ResultSet rst, int rowNum) throws SQLException {
				 College c = new College();
				 c.setId(rst.getInt(1));
				 c.setName(rst.getString(2));
				 c.setCity(rst.getString(3));
				return c;
			}
		};
		Map<String,Object> map = new HashMap();
		map.put("id", id);
		return jdbc.query("select * from college where colg_id=:id",map, rowMapper).get(0);
	}

	public void deleteCollege(int id) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		jdbc.update("delete from college where colg_id=:id", map);
		
	}

	public void postCollege(College college) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", college.getId());
		map.put("name", college.getName());
		map.put("city", college.getCity());
		
		String sql="insert into college(colg_id,colg_name,colg_city) values (:id,:name,:city)";
		 jdbc.update(sql, map);
		
	}

	public void updateCollege(int id, College newCollege) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("name", newCollege.getName());
		paramMap.put("city", newCollege.getCity());
		
		String sql="update college SET colg_name=:name, colg_city=:city where colg_id=:id";
		jdbc.update(sql, paramMap);
		
	}
	
}
