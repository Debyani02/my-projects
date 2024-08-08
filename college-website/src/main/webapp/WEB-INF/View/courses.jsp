<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Courses</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/studentregister.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script >


	window.onload=function()
	{
		var x=document.getElementById("table-list");
		x.style.display="none";
	}
	var ty;
	function takeValue()
	{
		var t=document.getElementById("type");
	    ty=t.value;
	}
	
	function getCourses()
     {
		
		
    		  
    		   $.ajax({
    			  
    			        url:"/listCoursesOnType?type="+ty,
    			        method:"GET",
    			        success: function(data){
    			        
    			        	console.log(data); 
    			        	 data.forEach(function(course)
    			        			{
    			        		       $("#tablehead tbody").append("<tr><td>"+course.course_id+"</td>"+"<td>"+course.course_name+"</td>"+"<td>"+course.duration+"</td>"+"<td>"+course.fee+"</td>"+"<td>"+course.type+"</td><tr>"); 
    			        	});
    			        	 
    			        }
    	       });
    		   
    		   var x=document.getElementById("table-list");
    			x.style.display="block";
    	    	
    		   
    	   
     }
</script>
</head>
<body>

	<section id="search">
		<div class="container" >
			<div class="row">
				<div class="col-md-12">
					<div class="top-head">
						<h1>Courses</h1>
					</div>
					<div class="form-area">
						<form method="get" action="">
							<label>Type</label> <select name="type" id="type" onchange="takeValue()">
								<option selected disabled>Select</option>
								<option value="UG">Under Graduation</option>
								<option value="PG">Post Graduation</option>
							</select>
						</form>
						<button onclick="getCourses()" class="btn-btn-primary">List</button>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="table-list">

		<table border="2" cellpadding="10" id="tablehead">
			<thead>
			<tr>
				<th>Course ID</th>
				<th>Course Name</th>
				<th>Duration</th>
				<th>Fee</th>
				<th>Type</th>
			</tr>
			</thead>
			<tbody>
			
			</tbody>


		</table>
	</section>

</body>
</html>