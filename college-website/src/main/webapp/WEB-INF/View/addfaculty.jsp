<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Faculty</title>
<link rel="icon" href="image/logo.jpg" type="image/x-icon">
<link rel="stylesheet" href="css/studentregister.css">
<link rel="stylesheet" href="css/bootstrap.css">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
var mydata;

     function Display()
     {
    	 var selected=document.getElementById("departments");
    	 var d=selected.value;
    	 mydata.forEach(function(department)
    	 {
    		if(department.department_name==d)
    			{
    			 document.getElementById("dept_id").value=department.department_id;
    			}
    	 });
    	 
    	 
     }
        
        	
        	window.onload=function getList()
       		 {
        		$(document).ready(function(){
       		  
       		   $.ajax({
       			  
       			        url: "/listDepartment",
       			        type:"get",
       			        success: function(data){
       			        	mydata=data;
       			        	console.log(data); 
       			        	 data.forEach(function(department)
       			        			{
       			        		       $("#departments").append("<option>"+department.department_name+"</option>"); 
       			        	});
       			        	 
       			        }
       	      	 });
       		   
       	   	});
        }
        	
        </script>
</head>
<body>
	<section class="#">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="top-head">
						<h1>Add Faculty</h1>
					</div>
					<div class="form-area">
						<form method="post" action="facultysave" enctype="multipart/form-data">
							<label>First Name</label><input class="entry-field" type="text"
								name="fname"> <label>Last Name</label><input
								class="entry-field" type="text" name="lname"><br> <label>Gender</label>&nbsp
							&nbsp <input type="radio" name="gender" value=Male>&nbsp
							Male &nbsp <input type="radio" name="gender" value=Female>&nbsp
							Female&nbsp<br> <label>Qualification</label> <select
								class="entry-field" name="qualification">
								<option selected disabled>Select</option>
								<option value="M.A">Master of Arts</option>
								<option value="M.Sc">Master of Science</option>
								<option value="M.Com">Master of Commerce</option>
								<option value="MCA">Master of Computer Application</option>
								<option value="MBA">Master of Business Administration</option>
								<option value="MJMC">Master of Journalism and Mass
									Communication</option>
							</select><br> 
							<label>Department</label> <select class="entry-field" name="dept_name" id="departments" onchange="Display()">
								<option selected disabled>Select</option>

							</select> 
							<input type="text" id="dept_id" name="dept_id">
							<br> 
							<label>E-mail</label><input class="entry-field" type="text" name="mail"> 
							<label>Phone no.</label><input class="entry-field" type="text" name="contact"><br>
							<label>Password</label><input class="entry-field" type="text" name="password"><br> 
							<label>Upload photo</label> <input type="file" name="profile_photo"><br>
							<button type="submit">Add</button>
							<button type="reset">Reset</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>