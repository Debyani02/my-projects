package com.college.college_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.college_management.pojo.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

}
