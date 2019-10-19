package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.ApplicationNote;

public interface ApplicationNoteRepository extends JpaRepository<ApplicationNote, Integer> {

	List <ApplicationNote> findByApplicationId(Integer appId);
}
