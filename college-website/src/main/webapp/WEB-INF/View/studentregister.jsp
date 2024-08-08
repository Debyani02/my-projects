<%@page import="com.college.college_management.pojo.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student registration</title>
<link rel="icon" href="image/logo.jpg" type="image/x-icon">
<link href="css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="css/studentregister.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
var ty;
function takeValue()
{
	var t=document.getElementById("type");
    ty=t.value;
    getCourseOptions();
    
}


function getCourseOptions()
{
	
	 
	
		  
		   $.ajax({
			  
			        url:"/listCoursesOnType?type="+ty,
			        method:"GET",
			        success: function(data){
			        
			        	console.log(data); 
			        	 data.forEach(function(course)
			        			{
			        		       $("#coursename").append("<option>"+course.course_name+"</option>"); 
			        	});
			        	 
			        }
	       });
		   
	   
}
</script>
</head>
<body>
	<section class="register">
        <div class="container-fluid">
            <div class="row">
                <div class="top-head">
                    <h1>Student Registration</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-area">
                        <form action="addstudent" method="post">
                            <label> Name</label><input class="entry-field" type="text" name="name" ><br>
                            <label>Type</label>
                            <select name="type" id="type" onchange="takeValue()">
                            	<option selected disabled>Select</option>
                                <option value="UG" >Under Graduate</option>
                                <option value="PG" >Post Graduate</option>
                            </select>
                            <label>Course</label>
                            <select name="course" id="coursename">
                                <option selected disabled>Select</option>
                            </select><br>
                            <label>Session</label>
                            <select name="session">
                            	<option selected disabled>Select</option>
                            	<option value="2024-2025">2024-2025</option>
                            	<option value="2025-2026">2025-2026</option>
                            </select><br>
                            
                            
                            <label>Gender</label>&nbsp &nbsp &nbsp<input  type="radio" name="gender" value="male">Male&nbsp &nbsp &nbsp<input  type="radio" name="gender" value="female">Female<br>
                            <label>Date of birth</label><input class="entry-field" type="date" name="dob" ><br>
                            <label>Create Password</label><input class="entry-field" type="password" name="password" >
                            <label>ConfirmPassword</label><input class="entry-field" type="password" name="cnfpassword" ><br>
                            <button type="submit" class="btn-btn-primary" >Register</button>&nbsp&nbsp
                            <button type="reset" class="btn-btn-primary">Reset</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>