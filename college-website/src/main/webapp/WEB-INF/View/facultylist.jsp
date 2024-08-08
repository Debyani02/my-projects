<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/studentregister.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
var dept;
var did;
function takeValue()
{
	var t=document.getElementById("departmentname");
	dept=t.value;
}

window.onload=function getCourseList()
{
	var x=document.getElementById("table-list");
	x.style.display="none";
	
	$(document).ready(function(){
		
	$.ajax({
				url:"/listDepartment",
				type:"GET",
				success:function(data){
					console.log(data);
					data.forEach(function(department)
					{
						
						$("#departmentname").append("<option>"+department.department_name+"</option>");
					
				});
	}
	
	});
	
	});
}

function showList()
{
	$.ajax({
		
				url:"/listFacultyOnDept?department_name="+dept,
				type:"GET",
				success:function(data){
					data.forEach(function(faculty){
						$("#tablehead tbody").append("<tr><td>"+faculty.facultyid+"</td><td>"+faculty.fname+"</td><td>"+faculty.lname+"</td><td>"+facullty.gender+"</td><td>"+faculty.contact+"</td><td>"+faculty.dept_id+"</td></tr>");
					});
				}
		
	});
	
	var x=document.getElementById("table-list");
	x.style.display="block";
	
}
</script>

</head>
<body>
<section id="#">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="top-head">
						<h1>Faculty</h1>
				</div>
				<div class="form-area">
						<form method="get" action="">
							<label>Department</label> <select id="departmentname" name="department_name" onchange="takeValue()">
								<option selected disabled>Select</option>
								
							</select><br>
							
						</form>
						<button onclick="showList()" class="btn-btn-primary">Show</button>
				</div>
			</div>
		</div>
	</div>
</section>

<section id="table-list">
	<table border="2" cellpadding="10" id="tablehead">
			<thead>
			<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Gender</th>
			<th>Contact</th>
			<th>Department ID</th>
			<th>Image</th>
			</tr>
			</thead>
			<tbody>
			</tbody>
	</table>
</section>
</body>
</html>