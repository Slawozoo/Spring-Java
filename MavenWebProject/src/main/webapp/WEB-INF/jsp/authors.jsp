<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Authors</title>
</head>
<body style="background-color: #e2e2e2">

	<!-- </h1><a href="add_authors"><h1>Add Authors</h1></a> -->
	<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name}  | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
    </c:if>
  </div>
	
	<div class="container mt-5">
				<center><h1>List of Authors</h1></center>
		<a href="/welcome" class="btn btn-info" style="font-weight: bold;">Home</a>
		<table class="table mt-5 table-info ">
		<sec:authorize access="hasRole('ADMIN')">
   			<a href="authorsform" class="btn btn-info" style="font-weight: bold;">Add New Authors</a>
		</sec:authorize>
			<!-- <a href="authorsform" class="btn btn-info" style="font-weight: bold;">Add
				New Authors</a> -->

			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Address</th>
					<th scope="col">Institution</th>
					<th scope="col">Email</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="authors" items="${list}">
					<tr>
						<th scope="row"><c:out value="${authors.authorId }" /></th>
						<td><c:out value="${authors.firstName}" /></td>
						<td><c:out value="${authors.lastName}" /></td>
						<td><c:out value="${authors.address}" /></td>
						<td><c:out value="${authors.institution}" /></td>
						<td><c:out value="${authors.email}" /></td>
						<td>
						<sec:authorize access="hasRole('ADMIN')">
						<a
							href="editauthorsform/<c:out value="${authors.authorId}"/>"
							class="btn btn-warning">Edit</a> <a
							href="deleteauthors/<c:out value="${authors.authorId}"/>"
							class="btn btn-danger">Delete</a>
							</sec:authorize>
						</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
</body>
</html>