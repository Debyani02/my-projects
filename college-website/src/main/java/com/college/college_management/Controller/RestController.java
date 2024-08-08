package com.college.college_management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.college_management.pojo.Course;
import com.college.college_management.pojo.Department;
import com.college.college_management.pojo.Faculty;
import com.college.college_management.pojo.Student;
import com.college.college_management.repository.CoursesRepository;
import com.college.college_management.repository.DepartmentRepository;
import com.college.college_management.repository.FacultyRepository;
import com.college.college_management.repository.StudentRepository;


@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	CoursesRepository crobj;
	
	@Autowired
	DepartmentRepository drobj;
	
	@Autowired
	StudentRepository srobj;
	
	@Autowired
	FacultyRepository frobj;
	
	@GetMapping("/listDepartment")
	public List<Department> listDepartment()
	{
		return drobj.findAll();
	}
	
	@GetMapping("/listCoursesOnType")
	public List<Course> listCourses(@RequestParam("type") String type)
	{
		System.out.println("Type: "+type);
		return crobj.getList(type);
	}
	
	@GetMapping("/listCoursesAll")
	public List<Course> listAllCourses()
	{
		return crobj.findAll();
	}
	
	@GetMapping("/listStudentsOnCourse")
	public List<Student> listStudentOnCourse(@RequestParam("course_name")String course_name)
	{
		return srobj.getStudentOfCourse(course_name);
	}
	@GetMapping("/listFacultyOnDept")
	public List<Faculty> listFacultyOnDept(@RequestParam("department_name")String department_name)
	{
		
		int dept_id=drobj.getDepartmentId(department_name);
		return frobj.getFacultyOfDept(dept_id);
	}
	
	@GetMapping("/listStudentsOnSem")
	public List<Student> listStudentOnSem(@RequestParam("course_name")String course_name,@RequestParam("sem")String sem)
	{
		List<Student>data=srobj.getStudentOfSem(course_name,sem);
		return data;
	}
	
	@GetMapping("/getStudentByRegistration")
	public List<Student> getStudentByRegistration(@RequestParam("reg_no")int reg_no)
	{
		return srobj.getStudent(reg_no);
	}
}	
