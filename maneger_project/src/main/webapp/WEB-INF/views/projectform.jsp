<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://localhost:8080/" target="_blank">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>project Form</title>

<!-- Bootstrap CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="../../js/checkValidate.js"></script>
<script type="text/javascript"
	src="https://formden.com/static/cdn/formden.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css" />
<link rel="stylesheet"
	href="https://formden.com/static/cdn/bootstrap-iso.css" />

<!--Font Awesome (added because you use icons in your prepend/append)-->
<link rel="stylesheet"
	href="https://formden.com/static/cdn/font-awesome/4.4.0/css/font-awesome.min.css" />
<!-- Inline CSS based on choices in "Settings" tab -->
<style>
.bootstrap-iso .formden_header h2, .bootstrap-iso .formden_header p,
	.bootstrap-iso form {
	font-family: Arial, Helvetica, sans-serif;
	color: black
}

.bootstrap-iso form button, .bootstrap-iso form button:hover {
	color: white !important;
}

.asteriskField {
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<tbody>
				<tr>
					<td colspan="1">
						<h2>project Form</h2> <spring:url value="/project/save"
							var="saveURL" />
						<fieldset>
							<form:form modelAttribute="project" method="POST"
								action="${saveURL}" cssClass="well form-horizontal"
								onsubmit="return checkPhone() && validateEmail() && validateGender() && checkmaxsize()">

								<div class="form-group">
									<label class="control-label col-sm-2 requiredField"> ID
										Project <span class="asteriskField"> * </span>
									</label>
									<c:choose>
										<c:when test="${not empty project.projectId }">
											<div class="col-md-8 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<form:input path="projectId" cssClass="form-control"
														required="required" readonly="true" />
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-md-8 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<form:input id="projectId" path="projectId"
														cssClass="form-control" readonly="true" />
												</div>
											</div>

										</c:otherwise>
									</c:choose>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField" for="date">
										Project Name <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-user"></i></span>
											<form:input path="projectName" cssClass="form-control"
												id="projectName" placeholder="Project name" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField" for="date">
										Create Date <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<form:input class="form-control" id="createDate"
												name="createDate" path="createDate" placeholder="MM/DD/YYYY"
												type="text" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField" for="date">
										Start Date <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<form:input class="form-control" id="startDate"
												name="startDate" path="startDate" placeholder="MM/DD/YYYY"
												type="text" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField" for="date">
										Deadline <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<form:input class="form-control" id="deadlineDate"
												name="deadlineDate" path="deadlineDate"
												placeholder="MM/DD/YYYY" type="text" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField" for="date">
										Finish Actual Date <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-calendar"> </i>
											</div>
											<form:input class="form-control" id="finishDate"
												name="finishDate" path="finishDate" placeholder="MM/DD/YYYY"
												type="text" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-2 requiredField">
										Discription </label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-list-alt"></i></span>
											<form:textarea path="discription" id="discription"
												placeholder="discription" class="form-control"
												required="true" rows="5"></form:textarea>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-sm-2 requiredField">
										Project Process <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-th-list"></i></span>
											<form:select path="projectState" class="form-control" id="sel1"
												style="height:30px" required="required">
												<form:option value="" label="--- Select ---" />
												<form:option value = "0" label="0%"/> 
												<form:option value = "10" label="10%"/> 
												<form:option value = "20" label="20%"/> 
												<form:option value = "30" label="30%"/>
												<form:option value = "40" label="40%"/>  
												<form:option value = "50" label="50%"/>  
												<form:option value = "60" label="60%"/> 
												<form:option value = "70" label="70%"/> 
												<form:option value = "80" label="80%"/> 
												<form:option value = "90" label="90%"/> 
												<form:option value = "100" label="100%"/> 
											</form:select>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="control-label col-sm-2 requiredField">
										Project Ouput <span class="asteriskField"> * </span>
									</label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-folder-open"></i></span>
											<form:input path="projectOutput" cssClass="form-control"
												required="required" placeholder="Project Ouput" />
										</div>
									</div>
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-primary">Save</button>
									<button type="button" class="btn btn-primary"
										onclick="return window.location='/project';">Cancel</button>
								</div>

							</form:form>
						</fieldset>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- Extra JavaScript/CSS added manually in "Settings" tab -->
	<!-- Include jQuery -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

	<!-- Include Date Range Picker -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
	<script>
		$(document).ready(
				function() {
					var date_input = $('input[name="date"]'); //our date input has the name "date"
					var container = $('.bootstrap-iso form').length > 0 ? $(
							'.bootstrap-iso form').parent() : "body";
					date_input.datepicker({
						format : 'yyyy-mm-dd',
						container : container,
						todayHighlight : true,
						autoclose : true,
					})
				})
	</script>
</body>
</html>