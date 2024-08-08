package com.college.college_management.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attendance {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int attendance_id;
private int registration_no;
private int roll_no;
private String student_name;
private String course;
private String semester;
private int days_present;
private int faculty_id;


public int getAttendance_id() {
	return attendance_id;
}
public void setAttendance_id(int attendance_id) {
	this.attendance_id = attendance_id;
}
public int getRegistration_no() {
	return registration_no;
}
public void setRegistration_no(int registration_no) {
	this.registration_no = registration_no;
}
public int getRoll_no() {
	return roll_no;
}
public void setRoll_no(int roll_no) {
	this.roll_no = roll_no;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}
public int getDays_present() {
	return days_present;
}
public void setDays_present(int days_present) {
	this.days_present = days_present;
}
public int getFaculty_id() {
	return faculty_id;
}
public void setFaculty_id(int faculty_id) {
	this.faculty_id = faculty_id;
}


}
