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
<title>Staff Form</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<!-- Font Awesome -->
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous" />
<!-- Custom style -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="../../js/checkValidate.js"></script>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<tbody>
				<tr>
					<td colspan="1">
						<h2>Staff Form</h2> <spring:url value="/staff/save" var="saveURL" />
						<fieldset>
							<form:form modelAttribute="staff" method="POST"
								action="${saveURL}" cssClass="well form-horizontal"
								onsubmit="return checkPhone() && validateEmail() && validateGender() && checkmaxsize()">

								<div class="form-group">
									<label class="col-md-4 control-label">ID Staff<span
										style="color: red"> * </span></label>
									<c:choose>
										<c:when test="${not empty staff.staffId }">
											<div class="col-md-8 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<form:input path="staffId" cssClass="form-control"
														required="required" readonly="true" />
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-md-8 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span>
													<form:input id="staffId" path="staffId"
														cssClass="form-control" required="required" />
												</div>
											</div>

										</c:otherwise>
									</c:choose>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">First Name <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-user"></i></span>
											<form:input path="firstName" cssClass="form-control"
												id="firstname" placeholder="First name" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Last Name <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-user"></i></span>
											<form:input path="lastName" cssClass="form-control"
												id="lastname" placeholder="Last name" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Full Name <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-user"></i></span>
											<form:input path="fullName" cssClass="form-control"
												id="fullname" placeholder="Full name" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Email <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-envelope"></i></span>
											<form:input path="email" cssClass="form-control" id="email"
												placeholder="Email" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Possition <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-home"></i></span>
											<form:input path="possition" cssClass="form-control"
												id="possition" placeholder="Possition" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Gender<span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-user"></i></span>
											<form:select path="gender" class="form-control"
												style="height:30px" id="sel1" required="required">
												<form:option value="male" label="--- Select ---" />
												<form:option value="male" lable="male" />
												<form:option value="female" lable="female" />
											</form:select>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Skill <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-book"></i></span>
											<form:input path="skill" cssClass="form-control" id="skill"
												placeholder="Skill" required="true" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label">Phone Number <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-earphone"></i></span>
											<form:input path="telephone" cssClass="form-control"
												id="telephone" placeholder="Phone Number" required="true" />
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">ID Department <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-th-list"></i></span>
											<form:select path="departmentId" class="form-control"
												style="height:30px" id="sel1" required="required">
												<form:option value="" label="--- Select ---" />
												<form:options items="${departments }" />
											</form:select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">ID Account <span
										style="color: red"> * </span></label>
									<div class="col-md-8 inputGroupContainer">
										<div class="input-group">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-th-list"></i></span>
											<form:select path="accountId" class="form-control" id="sel1"
												style="height:30px" required="required">
												<form:option value="" label="--- Select ---" />
												<form:options items="${accounts }" />
											</form:select>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-4 control-label">Discription</label>
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

								<div class="text-center">
									<button type="submit" class="btn btn-primary">Save</button>
									<button type="button" class="btn btn-primary"
										onclick="return window.location='/staff';">Cancel</button>
								</div>
							</form:form>
						</fieldset>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>