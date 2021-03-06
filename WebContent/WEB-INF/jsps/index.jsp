<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
body {
	padding: 20px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CollegeApp</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Courses</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/student">Student</a></li>
					<li class="nav-item">
						<!-- Expression language (EL) --> <!-- PageContext --> <!--request.getContextPath()h() %> -->
						<a class="nav-link" href="<%=request.getContextPath()%>/college">College</a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Departments </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">IT</a></li>
							<li><a class="dropdown-item" href="#">COMPS</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Others</a></li>
						</ul></li>

				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				&nbsp;&nbsp;&nbsp;
				<form class="d-flex">
					<button class="btn btn-primary" type="submit">LOGIN</button>
				</form>
			</div>
		</div>
	</nav>
	<h1>
		<%=request.getAttribute("title")%>
	</h1>
	<div class="row">
		<!--  total: 12  -->
		<div class="col-sm-4">
			<sf:form  action="${pageContext.request.contextPath }/add-student" 
			method="GET" modelAttribute="student">
			
				<fieldset>
					<legend> Student Registration </legend>
					<div>
					ID: <sf:input type="text" path="id" class="form-control" /> <br />
					Name: <sf:input type="text" path="name" class="form-control" /><br />
					Email: <sf:input type="text" path="email" class="form-control" /><br />
					City: <sf:input type="text" path="city" class="form-control" /><br />
					<input type="submit" value="Register" class="btn btn-primary">
					</div>
				</fieldset>

			</sf:form>

		</div>
		<div class="col-sm-8"></div>
	</div>

</body>


<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

</html>