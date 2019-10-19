package com.skilldistillery.jobtracking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.ApplicationNote;

public interface ApplicationNoteRepository extends JpaRepository<ApplicationNote, Integer> {

	@Query(value="SELECT an FROM ApplicationNote an JOIN FETCH an.application WHERE an.application.id = :id")
	List <ApplicationNote> findByAppId(@Param("id")Integer appId);
}
