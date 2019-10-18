package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Company;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

	
	Company findByName(String name);
	
}
