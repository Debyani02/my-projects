package com.college.college_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.college_management.pojo.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("Select d.department_id from Department d where d.department_name=:department_name")
    int getDepartmentId(@Param("department_name")String department_name);
}
