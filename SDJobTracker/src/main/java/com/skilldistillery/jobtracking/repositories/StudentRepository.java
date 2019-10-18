package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	@Query(value="SELECT s FROM Student s JOIN FETCH s.user WHERE s.user.username = :username")
	Student findByUserame(@Param("username")String username);
	
	@Query(value="SELECT s FROM Student s JOIN FETCH s.cohort WHERE s.cohort.id = :id")
	List <Student> findByCohortId(@Param("id") Integer id);

	@Query(value="SELECT s From Student s WHERE s.firstName LIKE :name OR s.lastName LIKE :name")
	List <Student> findByName(@Param("name") String name);

}
