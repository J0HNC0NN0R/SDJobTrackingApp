package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.StudentAddress;

public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer> {

	List<StudentAddress> findByStudentId(Integer studentId);
	
}
