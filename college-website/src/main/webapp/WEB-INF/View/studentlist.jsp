<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/studentregister.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">	
var c;
var ses;
function takeValue()
{
	var t=document.getElementById("coursename");
    c=t.value;
}



function showList()
{
	$.ajax({
		
				url:"/listStudentsOnCourse?course_name="+c,
				type:"GET",
				success:function(data){
					data.forEach(function(student){
						$("#tablehead tbody").append("<tr><td>"+student.registration_no+"</td><td>"+student.roll_no+"</td><td>"+student.name+"</td>"+"<td>"+student.dob+"</td><td>"+student.gender+"</td><td>"+student.course+"</td><td>"+student.semester+"</td><td>"+student.session+"</td></tr>");
					});
				}
		
	});
	
	var x=document.getElementById("table-list");
	x.style.display="block";
	
}

	

	window.onload=function getCourseList()
	{
		var x=document.getElementById("table-list");
		x.style.display="none";
		
		$(document).ready(function(){
			
		$.ajax({
					url:"/listCoursesAll",
					type:"GET",
					success:function(data){
						console.log(data);
						data.forEach(function(course)
						{
							
							$("#coursename").append("<option>"+course.course_name+"</option>");
						
					});
		}
		
		});
		
		});
	}
	
	
	
</script>
</head>
<body>
	<section id="search">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="top-head">
						<h1>Students</h1>
					</div>
					<div class="form-area">
						<form method="get" action="">
							<label>Course</label> <select id="coursename" name="course_name" onchange="takeValue()">
								<option selected disabled>Select</option>
								
							</select><br>
							
						</form>
						<button onclick="showList()" class="btn-btn-primary">Search</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section id="table-list">

		<table border="2" cellpadding="10" id="tablehead">
			<thead>
			<tr>
				<th>Registration</th>
				<th>Roll No.</th>
				<th> Name</th>
				<th> DOB </th>
				<th>Gender</th>
				<th>Course</th>
				<th>Semester</th>
				<th>Session</th>
			</tr>
			</thead>
			<tbody>
			
			</tbody>


		</table>
	</section>
	
</body>
</html>