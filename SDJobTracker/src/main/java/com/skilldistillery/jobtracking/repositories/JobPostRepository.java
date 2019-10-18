package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.JobPost;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

}
