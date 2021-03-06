<%-- <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<title>Spring MVC</title>
</head>
<body style="background-color: #e2e2e2">

<!-- </h1><a href="add_authors"><h1>Add Authors</h1></a> -->
<div class="container mt-5">
<h1 align="center" style="font-weight: bold;">Spring MVC CRUD
			Operations using JPA</h1>
<center><a href="authorsform" class="btn btn-info" style="font-weight: bold;">Add New Authors</a>
<a href="authors" class="btn btn-info" style="font-weight: bold;">View Authors</a></center>

</div>
  
</body>
</html>



 --%>
 
 
 <%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<title>Spring Security</title>
</head>
<body style="background-color: #e2e2e2">

	<!-- </h1><a href="add_authors"><h1>Add Authors</h1></a> -->
	<div class="container mt-5">
		<h1 align="center" style="font-weight: bold;">Spring Security
			with Registration and Login Form to CRUD operations for Authors</h1>
		<center>
			<a href="${contextPath}/registration" class="btn btn-info"
				style="font-weight: bold;">Register new User</a> 
			<a href="${contextPath}/login" class="btn btn-info style=" font-weight: bold;">User Login</a>
			<a href="${contextPath}/authors" class="btn btn-info style=" font-weight:bold;">View Authors</a>
		</center>

	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>



 