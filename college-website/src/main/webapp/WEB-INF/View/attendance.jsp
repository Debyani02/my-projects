<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/studentregister.css">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
var c;
var s;
function takeValue()
{
	var t=document.getElementById("course_name");
    c=t.value;
}
function takeSem()
{
	var t=document.getElementById("sem");
	s=t.value;
}

function getStudentsList(){
	
	$.ajax({
		
		url:"/listStudentsOnSem?course_name="+c+"&sem="+s,
		type:"GET",
		success:function(data){
			data.forEach(function(student){
				$("#tablehead tbody").append("<tr><td>"+student.registration_no+"</td><td>"+student.roll_no+"</td><td>"+student.name+"</td><td>"
					+"Mark Present"+"</td></tr>"	);
			});
			
		}
	});
			var x=document.getElementById("attendance-sheet");
			x.style.display="block";
}


window.onload=function getCourseList()
{
	var x=document.getElementById("attendance-sheet");
	x.style.display="none";
	
	$(document).ready(function(){
		
	$.ajax({
				url:"/listCoursesAll",
				type:"GET",
				success:function(data){
					console.log(data);
					data.forEach(function(course)
					{
						
						$("#course_name").append("<option>"+course.course_name+"</option>");
					
				});
	}
	
	});
	
	});
}
</script>
</head>
<body>
	<section id="#">
		<div class=container>
			<div class=row>
				<div class=col-md-12>
					<div class="top-head">
						<h1>Attendance</h1>
					</div>
					<div class="form-area">
						<form action="" method="post">
							<label>Course</label> <select name="course_name" id="course_name"
								onchange="takeValue()">
								<option selected disabled>Select</option>
							</select><br> <label>Semester</label> <select name="sem" id="sem"
								onchange="takeSem()">
								<option selected disabled>Select</option>
								<option value=1>Sem-I</option>
								<option value=2>Sem-II</option>
								<option value=3>Sem-III</option>
								<option value=4>Sem-IV</option>
								<option value=5>Sem-V</option>
								<option value=6>Sem-VI</option>
							</select>
						</form>
						<button onclick="getStudentsList()" class="btn-btn-primary">Search</button>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="attendance-sheet">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="sheet">
						<table id="tablehead" border="2" cellpadding="10">
							<thead>
								<tr>
									<th>Registration</th>
									<th>Roll No.</th>
									<th>Name</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
	</section>
</body>
</html>