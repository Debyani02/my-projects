<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Main Page</title>
        <link rel="icon" href="image/logo.jpg" type="image/x-icon">
        <link rel="stylesheet" href="css/dashboard.css">
    </head>
    <body>
    
    <%
    	String admin=request.getParameter("username");
    	session.setAttribute("username",admin);
    %>
        <section class="menu">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                      <div class="menu-left">
                        <div class="top-tag">
                            <img src="image/logo.jpg" alt="logo" height="50px">
                            Administrator
                        </div>
                        <hr>
                        <div class="admin-options">
                            <div class="item">
                                <a href="courses" target="iframe_display_area">Courses</a>
                            </div>
                            <div class="item">
                                <a href="studentlist" target="iframe_display_area">Students</a>
                            </div>
                            <div class="item">
                                <a href="facultylist" target="iframe_display_area">Faculties</a>
                            </div>
                            <div class="item">
                                <a href="marksentry" target="iframe_display_area">Enter Marks</a>
                            </div>
                            <div class="item">
                                <a href="marksheet" target="iframe_display_area">Marksheet</a>
                            </div>
                            <div class="item">
                                <a href="attendance" target="iframe_display_area">Mark Attendance</a>
                            </div>
                            <div class="item">
                                <a href="#" target="iframe_display_area">Attendance Report</a>
                            </div>
                            <div class="item">
                                <a href="addfaculty" target="iframe_display_area">Add Faculty</a>
                            </div>
                            <div class="item">
                                <a href="#" target="iframe_display_area">Update Student Info</a>
                            </div>
                            <div class="item">
                                <a href="#" target="iframe_display_area">Update Faculty Info</a>
                            </div>
                            <div class="item">
                                <a href="addcourse" target="iframe_display_area">Add Courses</a>
                            </div>
                            <div class="item">
                                <a href="#" target="iframe_display_area">Update Courses</a>
                            </div>
                            
                            <div class="item">
                                <a href="adminlogin">Logout</a>
                            </div>
                        </div>
                      </div>
                    </div>
                   <div class="display-area">
                   	<div class="col-md-9">
                   	 <iframe name="iframe_display_area" src="defaultdashboard" height="720" width="1220">
                   	 </iframe>
                   </div>
                   </div>
                </div>
            </div>
        </section>
    </body>
</html>