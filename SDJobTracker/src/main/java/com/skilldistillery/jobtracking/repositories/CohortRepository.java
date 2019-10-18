package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Cohort;

public interface CohortRepository extends JpaRepository<Cohort, Integer> {

}
