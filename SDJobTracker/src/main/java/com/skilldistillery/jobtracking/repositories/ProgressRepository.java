package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Integer> {

	
	List<Progress> findByApplicationId(Integer appId);
	
	
}
