package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

	List <Event> findByStudentId(Integer studentId);
	
}
