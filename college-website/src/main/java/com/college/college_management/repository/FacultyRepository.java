package com.college.college_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.college_management.pojo.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Integer>{

	@Query("SELECT f FROM Faculty f WHERE f.email =:username AND f.password =:password")
	Faculty getFacultyLoginByUsernameANDPassword(@Param("username") String username,@Param("password") String password);
	
	@Query("SELECT f from Faculty f WHERE f.dept_id=:dept_id")
	List<Faculty> getFacultyOfDept(@Param("dept_id")int dept_id);
}
