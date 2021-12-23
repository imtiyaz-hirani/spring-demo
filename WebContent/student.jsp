<%@page import="com.myproject.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Students</h1>

<%
	List<Student> list = (List<Student>)request.getAttribute("studentList");

	for(Student s :list){
		out.println(s + "<br />");
	}
%>
</body>
</html>