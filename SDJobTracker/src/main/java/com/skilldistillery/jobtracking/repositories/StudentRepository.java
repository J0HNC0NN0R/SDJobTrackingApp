package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query(value="SELECT s FROM Student s JOIN FETCH s.user WHERE s.user.username = :username")
	Student findByUserame(@Param("username")String username);
}
