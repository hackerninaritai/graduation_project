<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<title>Registration Form</title>
<link rel="stylesheet" type="text/css"
	th:href="@{/css/registration.css}" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="/" method="get">
		<button class="btn btn-md btn-warning btn-block" type="Submit">Go
			To Login Page</button>
	</form>

	<div class="container">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<form:form modelAttribute="account" method="post" action="${registration}"
					cssClass="form" >
					<h2>Registration Form</h2>

					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="text" path="accountName" placeholder="email"
								class="form-control" />
						</div>
					</div><br>
					<div class="form-group">
						<div class="col-sm-9">
							<form:input type="password" path="password"
								placeholder="Password" class="form-control" />
						</div>
					</div><br>
						<div class="form-group">
						<div class="col-sm-9">
							<form:input type="role" path="roleId"
								placeholder="role" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-9">
							<button type="submit" class="btn btn-primary btn-block">Register
								User</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>