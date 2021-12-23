<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> College</h1>

<%=request.getAttribute("count") %>
<br />
<%=request.getAttribute("studentName") %>
<br />
 <hr>
 <a href="<%=request.getContextPath() %>/course?courseName=Angular"> Angular </a> <br />
 <a href="<%=request.getContextPath() %>/course?courseName=Java"> JAVA </a><br />
 <a href="<%=request.getContextPath() %>/course?courseName=Python"> Python </a><br />
</body>
</html>