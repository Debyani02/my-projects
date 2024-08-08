<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add Course</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/studentregister.css">

<script>
	function validateCourse(){
		let t=document.newcourse.type.value;
		let name=document.newcourse.coursename.value;
		let duration=document.newcourse.duration.value;
		let fee=document.newcourse.fee.value;
		
		if(t==null||t==""){
			alert("Select type of course ");
			return false;
		}
		else if(name==""||name=null){
			alert("Course name cannot be blank ");
			return false;
		}
		else if(duration==null){
			alert("Select the course duration");
			return false;
		}
		else if(fee==""||fee==null){
			alert("Fee cannot be blank ");
			return false;
		}
		else if(fee<10000){
			alert("Fee cant be less than 10,000")
			return false;
		}
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="top-head">
					<h1>Add Course</h1>
				</div>
				<div class="form-area">
					<form method="post" action="savecourse" name="newcourse">
						<label>Type</label><select name="type" class="entry-field">
							<option selected disabled>Select</option>
							<option value="UG">Under Graduation</option>
							<option value="PG">Post Graduation</option>
						</select><br> <label>Course Name</label><input class="entry-field"
							type="text" name="coursename"><br> <label>Duration</label><select
							name="duration" class="entry-field">
							<option selected disabled>Select</option>
							<option value="2years">2 years(4 semesters)</option>
							<option value="3years">3 years(6 semesters)</option>
						</select><br> <label>Course Fee</label><input class="entry-field"
							type="text" name="fee"><br>
						<button type="submit" class="btn-btn-primary" onclick="validateCourse()">Add Course</button>
						<button type="reset" class="btn-btn-primary">Reset</button>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>