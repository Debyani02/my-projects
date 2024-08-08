package com.college.college_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.college.college_management.pojo.Admin;



public interface AdminRepository extends JpaRepository<Admin, Integer>{
		
	

	@Query("SELECT u FROM Admin u WHERE u.username =:username AND u.password =:password")
	Admin getAdminLoginByUsernameANDPassword(@Param("username") String username,@Param("password") String password);
	

}
