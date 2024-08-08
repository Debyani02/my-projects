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


	window.onload=function()
	{
		var x=document.getElementById("table-list");
		x.style.display="none";
	}

	function searchStudent(){
		var t=document.getElementById("reg_no");
		var r_no=t.value;
		
		$.ajax({
			url:"/getStudentByRegistration?reg_no="+r_no,
			type:"GET",
			success:function(data){
				data.forEach(function(student){
					$("#tablehead tbody").append("<tr><td>"+student.registration_no+"</td><td>"+student.roll_no+"</td><td>"+student.name+"</td><td>"+student.course+"</td><td>"+student.semester+"</td><td>"+"Marks Enter"+"</td></tr>");
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
		<div class=container>
			<div class=row>
				<div class=col-md-12>
					<div class="top-head">
						<h1>Marks Entry</h1>
					</div>
					<div class="form-area">
						<form method="post">
							<label>Registration no.</label><input type="text" name="reg_no" id="reg_no">
						</form>
						<button onclick="searchStudent()" class="btn-btn-primary">Search</button>
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
				<th>Course</th>
				<th>Semester</th>
				<th>Action</th>
			</tr>
			</thead>
			<tbody>
			
			</tbody>


		</table>
	</section>
</body>
</html>