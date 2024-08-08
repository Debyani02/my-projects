package com.college.college_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.college_management.pojo.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	@Query("Select s from Student s where s.course=:course_name")
	List<Student> getStudentOfCourse(@Param("course_name")String course_name);

	@Query("Select s from Student s where s.course=:course_name AND s.semester=:sem")
	List<Student> getStudentOfSem(@Param("course_name")String course_name,@Param("sem")String sem);

	@Query("Select s from Student s where s.registration_no=:reg_no")
	List<Student> getStudent(@Param("reg_no")int reg_no);

	@Query("SELECT s FROM Student s WHERE s.registration_no =:username AND s.password =:password")
	Student getStudentLoginByUsernameANDPassword(String username, String password);
}
