<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Faculty Dashboard</title>
<link rel="icon" href="image/logo.jpg" type="image/x-icon">
<link rel="stylesheet" href="css/dashboard.css">

</head>
<body>

	<%
	    String faculty_name=request.getParameter("username");
		session.setAttribute("username", faculty_name);
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
						<div class="admin-options" >
							<div class="item">
								<a href="facultyprofile"  target="iframe_display_area">Profile</a>
							</div>
							<div class="item">
								<a href="attendance" target="iframe_display_area">Mark Attendance</a>
							</div>
							<div class="item">
								<a href="">Attendance</a>
							</div>
							<div class="item">
								<a href="studentlist" target="iframe_display_area">View Students</a>
							</div>
							<div class="item">
								<a href="#">Blog Post</a>
							</div>
							<div class="item">
								<a href="facultyloginpage">Logout</a>
							</div>
						</div>
					</div>
				</div>
				<div class="display-area">
					<div class="col-md-9">
						<iframe name="iframe_display_area" src="defaultfacultydashboard"
							height="720" width="1220"> 
						</iframe>
					</div>
				</div>
			</div>
		</div>
</body>
</html>