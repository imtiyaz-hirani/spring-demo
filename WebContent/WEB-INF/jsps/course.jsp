<%@page import="com.myproject.model.Course"%>
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
<h1>Course</h1>
<p>U Selected: <%=request.getAttribute("courseName") %></p>
<hr />
<h2>Course List</h2>
 	<hr />
 	<ul class="list-group">
 	<% 
	List<Course> list = (List<Course>)request.getAttribute("list");

	for(Course c :list){
		%>
			<li class="list-group-item">
		<%
		out.println(c.getId() +  "--" + c.getName() + "--" + c.getCredits() +"<br />");
		%>
			</li>
		<%
	}
	%>
	</ul>
</body>
</html>