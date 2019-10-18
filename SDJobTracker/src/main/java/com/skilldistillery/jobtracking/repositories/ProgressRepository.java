package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Integer> {

}
