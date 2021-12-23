package com.myproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myproject.model.Student;

public class StudentDB {
	//step 1: creating DB infi variables
	private String userDB="postgres";
	private String passDB="oais2ehe"; //change the password accordingly 
	private String url="jdbc:postgresql://localhost:5432/postgres";
	private String driver="org.postgresql.Driver";
	
	private Connection con; 
	//step 2: load the driver and create the connection
	
	public void dbConnect() throws ClassNotFoundException, SQLException {
		//loading the driver
		Class.forName(driver); 
		//create the connection and save it in con 
		con = DriverManager.getConnection(url, userDB, passDB);
	}
	
	public void dbClose() throws SQLException {
		con.close();
	}
	
	public void insertStudent(Student student) throws SQLException, ClassNotFoundException {
		dbConnect();
		
		String sql="insert into student(stud_id,stud_name,stud_city,stud_email, colg_id) values (?, ?, ?, ?, ?)";
		//Prepare the statement that will run/execute the query
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, student.getId());
		pstmt.setString(2, student.getName());
		pstmt.setString(3, student.getCity());
		pstmt.setString(4, student.getEmail());
		pstmt.setInt(5, 1);
		
		//execute the statement 
		pstmt.executeUpdate();
		
		dbClose();
	}
	
	public void deleteStudent(int id) {
		 
		
	}
	
	public void editStudent() {
		
	}
	
	public void fetchStudent() {
		
	}
	
	public void fetchStudentById() {
		
	}
	
}
