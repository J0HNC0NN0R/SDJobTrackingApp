package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.CompanyLocation;

public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Integer> {

}
