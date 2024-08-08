<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/dashboard.css">
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<div class="col-md-9">
		<div class="content-area">
			<div class="welcome-msg">
				<div class="welcome-head">Welcome 
				<%
					String name=(String)session.getAttribute("username");
					out.print("  "+name);
				%>

				</div>
			</div>
			<div class="cards">
				<div class="card-item">
					<div class="course-card">
						<img src="image/course-icon.png" height="150px">
						<h3>Blogs Posted 20</h3>
					</div>
				</div>
				<div class="card-item">
					<div class="faculty-card">
						<img src="image/faculty-icon .png" height="150px">
						<h3>Contributions 5</h3>
					</div>
				</div>
				<div class="card-item">
					<div class="student-card">
						<img src="image/student-icon.png" height="150px">
						<h3>Students 3345</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>