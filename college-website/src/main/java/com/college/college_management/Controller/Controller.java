package com.college.college_management.Controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.college.college_management.repository.AdminRepository;
import com.college.college_management.repository.CoursesRepository;
import com.college.college_management.repository.DepartmentRepository;
import com.college.college_management.repository.FacultyRepository;
import com.college.college_management.repository.StudentRepository;

import jakarta.servlet.ServletContext;

import com.college.college_management.pojo.Admin;
import com.college.college_management.pojo.Course;
import com.college.college_management.pojo.Faculty;
import com.college.college_management.pojo.Student;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	AdminRepository adminobj;
	
	@Autowired
	FacultyRepository facultyobj;
	
	
	
	@Autowired
	CoursesRepository courseobj;
	
	@Autowired
	StudentRepository studobj;
	
	@Autowired
	DepartmentRepository drobj;
	
	@Autowired
	ServletContext servletContexs;

	@GetMapping("/index")
	public String index() {

		return "index";
	}

	@GetMapping("/admindashboard")
	public String adminDashboard() {

		return "admindashboard";
	}

	@GetMapping("/studentloginpage")
	public String studentLogoin() {

		return "studentloginpage";
	}

	@GetMapping("/adminlogin")
	public String adminLogin() {

		return "adminlogin";
	}

	@GetMapping("/defaultdashboard")
	public String defaultDashboard()
	{
		
		
		return "defaultdashboard";
	}
	
	@GetMapping("/facultyloginpage")
	public String facultyLogin() {

		return "facultyloginpage";
	}
	
	@PostMapping("/savecourse")
	public String saveCourse(@RequestParam String type,String coursename,String duration,@RequestParam double fee)
	{
		
		Course course=new Course();
		course.setCourse_name(coursename);
		course.setType(type);
		course.setDuration(duration);
		course.setFee(fee);
		courseobj.save(course);
		return "redirect:/addcourse";
	}
	
	@GetMapping("/addcourse")
	public String addCourse()
	{
		return "addcourse";
	}

	@GetMapping("/contactus")
	public String contactUs() {

		return "contactus";
	}

	@PostMapping("/admin_validate")
	public String adminValidation(@RequestParam String username, @RequestParam String password) {

		
		Admin ab = adminobj.getAdminLoginByUsernameANDPassword(username, password);
		if (ab != null) {
			return "admindashboard";
		} else {
			
			return "redirect:/adminlogin";
		}

		
	}
	
	@PostMapping("/faculty_validate")
	public String facultyValidation(@RequestParam String username, @RequestParam String password) {

		
		Faculty ab = facultyobj.getFacultyLoginByUsernameANDPassword(username, password);
		if (ab != null) {
			return "facultydashboard";
		} else {
			
			return "redirect:/facultyloginpage";
		}

		
	}
	@PostMapping("/student_validate")
	public String studentValidation(@RequestParam String username, @RequestParam String password)
		{
			Student s=studobj.getStudentLoginByUsernameANDPassword(username,password);
			if (s != null) {
				return "studentdashboard";
			} else {
				
				return "redirect:/studentloginpage";
			}
		}
	
	@PostMapping("/addstudent")
	public String addStudent(@RequestParam String name,String course,String session, String gender,java.sql.Date dob,String password) {
		
		Student s=new Student();
		s.setName(name);
		s.setPassword(password);
		s.setGender(gender);
		s.setCourse(course);
		s.setSession(session);
		s.setDob(dob);
		s.setSemester("1");
		studobj.save(s);
		return "studentregister";
	}
	
	@GetMapping("/studentregister")
	public String studentRegister()
	{
		
		
		
		return"/studentregister";
	}
	
	@GetMapping("/addfaculty")
	public String addFaculty() {
		
		return "addfaculty";
	}
	
	@PostMapping("/facultysave")
	public String facultySave(@RequestParam String fname,@RequestParam String lname,@RequestParam String gender,@RequestParam String qualification,@RequestParam String mail,@RequestParam String password,@RequestParam String contact,@RequestParam int dept_id,@RequestParam MultipartFile profile_photo) 
	{
		
		String uploadDir="/static/images";
		String realPath=servletContexs.getRealPath(uploadDir);
		
		File fileDir=new File(realPath);
		
		if(!fileDir.exists())
		{
			fileDir.mkdirs();
		}
		
		String fileName=System.currentTimeMillis()+"_"+profile_photo.getOriginalFilename();
		String filePath=fileDir+"/"+fileName;
		
		File dest=new File(filePath);
		
		
		
		try {
			
			profile_photo.transferTo(dest);
			Faculty fobject = new Faculty();
			fobject.setFname(fname);
			fobject.setLname(lname);
			fobject.setGender(gender);
			fobject.setQualification(qualification);
			fobject.setContact(contact);
			fobject.setPassword(password);
			fobject.setEmail(mail);
			fobject.setDept_id(dept_id);
			fobject.setPhoto(filePath);
			facultyobj.save(fobject);
		  }
		catch(Exception e){
			System.out.println("Error : "+e);
		}
		
		return "redirect:/addfaculty";
	}
	

	@GetMapping("/courses")
	public String courses1()
	{
		
		return "courses";
	}
	
	@PostMapping("/courses")
	public String courses(@RequestParam("type")String type)
	{
		System.out.print(type);
		
		return "courses";
	}
	
	
	
	@GetMapping("/facultydashboard")
	public String facultyDashboard()
	{
		
		
		return"facultydashboard";
	}
	@GetMapping("/defaultfacultydashboard")
	public String defaultfacultydashboard()
	{
		return "/defaultfacultydashboard";
	}
	
	
	@GetMapping("/studentlist")
	public String studentList()
	{
		return "studentlist";
	}
	
	@GetMapping("/attendance")
	public String attendance()
	{
		return "attendance";
	}
	
	@GetMapping("/facultylist")
	public String facultyList()
	{
		return "facultylist";
	}
	@GetMapping("/marksentry")
	public String marksEntry()
	{
		return "marksentry";
	}
	
	@GetMapping("/marksheet")
	public String markSheet()
	{
		return "marksheet";
	}
	@GetMapping("/facultyprofile")
	public String facultyProfile()
	{
		return "facultyprofile";
	}
	
	@GetMapping("/studentdashboard")
	public String studentdashboard()
	{
		return "studentdashboard";
	}
	
	@GetMapping("/defaultstudentdashboard")
	public String defaultstudentdashboard()
	{
		return "defaultstudentdashboard";
	}
}
