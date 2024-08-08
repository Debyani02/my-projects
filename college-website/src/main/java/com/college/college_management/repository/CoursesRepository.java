package com.college.college_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.college_management.pojo.Course;

public interface CoursesRepository extends JpaRepository<Course, Integer>{

	@Query("Select c from Course c where c.type=:type")
	List<Course> getList(@Param("type")String type);
	
}
