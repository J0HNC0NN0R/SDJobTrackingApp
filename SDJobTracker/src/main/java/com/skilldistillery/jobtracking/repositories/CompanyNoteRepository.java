package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.CompanyNote;

public interface CompanyNoteRepository extends JpaRepository<CompanyNote, Integer> {

	@Query(value="SELECT c FROM CompanyNote c JOIN FETCH c.company WHERE c.company.name = :companyname AND c.student.id = :studentid")
	CompanyNote getCompanyNote(@Param("companyname")String string,@Param("studentid")Integer id);
}
