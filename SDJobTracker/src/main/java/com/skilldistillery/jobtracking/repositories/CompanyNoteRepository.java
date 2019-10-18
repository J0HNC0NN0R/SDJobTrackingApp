package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.CompanyNote;

public interface CompanyNoteRepository extends JpaRepository<CompanyNote, Integer> {

	@Query(value="SELECT c FROM CompanyNote c JOIN FETCH c.company WHERE c.company.id = :companyid AND c.student.id = :studentid")
	CompanyNote getCompanyNote(@Param("companyid")Integer cid,@Param("studentid")Integer id);
}
