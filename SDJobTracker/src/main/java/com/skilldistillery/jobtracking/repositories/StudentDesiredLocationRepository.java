package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.StudentDesiredLocation;

public interface StudentDesiredLocationRepository extends JpaRepository<StudentDesiredLocation, Integer> {

}
