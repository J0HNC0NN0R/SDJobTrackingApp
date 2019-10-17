package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

@Query(value="SELECT a FROM Application a JOIN FETCH a.student WHERE a.student.id = :id")	
List <Application> findApplicationsByStudentId(@Param("id")Integer id);
	
	
}
