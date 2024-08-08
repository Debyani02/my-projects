<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FAculty Login </title>
        <link rel="icon" href="image/logo.jpg" type="image/x-icon">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" 
        integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
         crossorigin="anonymous" referrerpolicy="no-referrer" />
        
          <script>
	function validateForm(){
		let user=document.loginform.username.value;
		let pass=document.loginform.password.value;
		
		if(user==null||user=="")
		{
			alert("Username can't be blank");
			return false;
		}
		else if(password==null){
			alert("Password can't be empty");
			return false;
		}
			
	}
</script>
    </head>
    <body>
        <div class="conatiner ">
            <div class="row">
                <div class="form-space ">
                	<div class="top-right"><a href="/index"><i class="fa-solid fa-house"></i></a></div>
                    <div class="dp" ><img src="image/faculty-profile.png" height="100px"></div>
                    <div class="form-area">
                        <form method="post" action="faculty_validate" name="loginform">
                            <label>Username</label>
                            <input class="form-control" type="text" name="username" placeholder="Username/Email">
                            <label>Password</label>
                            <input class="form-control" type="password" name="password" placeholder="Password">
                            <button type="submit" onclick="validateForm()">Login</button>
                            <button type="reset">Reset</button>
                        </form>
                    </div>
                    <a href="#">Forgot passsword?</a>
                </div>
            </div>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
    </body>
</html>