package com.myproject.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.myproject.model.Student;
@Component
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
	
	public int deleteStudent(int id) throws SQLException, ClassNotFoundException {
		 dbConnect();
		 int status; 
		 String sql="delete from student where stud_id=?";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, id);
		 
		 status = pstmt.executeUpdate();
		 dbClose();
		 
		 return status; 
	}
	
	public void editStudent() {
		
	}
	
	public List<Student> fetchStudent() throws ClassNotFoundException, SQLException {
		dbConnect();
		String sql="select * from student";
		PreparedStatement pstmt = con.prepareStatement(sql);
		List<Student> list = new ArrayList<>();
		ResultSet rst = pstmt.executeQuery();
		
		while(rst.next()) {
			//Read each row in 's' one by one 
			int id = rst.getInt(1);
			String name = rst.getString(2);
			String city = rst.getString(3);
			String email = rst.getString(4);
			Student s = new Student(id,name,email,city); 
			//save 's' in the list
			list.add(s); //harry 
			
		}
		dbClose();
		return list; 
	}
	
	public void fetchStudentById() {
		
	}
	
}
