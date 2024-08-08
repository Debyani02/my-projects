<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/dashboard.css">
</head>
<body>

<%
	    String student_name=request.getParameter("username");
		session.setAttribute("username", student_name);
	%>
	<section class="menu">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="menu-left">
						<div class="top-tag">
							<img src="image/logo.jpg" alt="logo" height="50px">

						</div>
						<hr>
						<div class="admin-options">
							<div class="item">
								<a href="#" target="iframe_display_area">Profile</a>
							</div>
							<div class="item">
								<a href="#" target="iframe_display_area">Attendance</a>
							</div>
							<div class="item">
								<a href="#" target="iframe_display_area">Fee Payment</a>
							</div>
							<div class="item">
								<a href="#" target="iframe_display_area">Result</a>
							</div>
							<div class="item">
								<a href="studentloginpage">Logout</a>
							</div>
						</div>
					</div>
				</div>
				<div class="display-area">
					<div class="col-md-9">
						<iframe name="iframe_display_area" src="defaultstudentdashboard"
							height="720" width="1220"> </iframe>
					</div>
				</div>
			</div>
		</div>
</body>
</html>