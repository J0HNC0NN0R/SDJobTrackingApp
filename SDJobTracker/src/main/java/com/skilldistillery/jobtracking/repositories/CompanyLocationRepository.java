package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.jobtracking.entities.CompanyLocation;

public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Integer> {

	@Query(value="SELECT cl FROM CompanyLocation cl WHERE cl.city = :city AND cl.state = :state")
	CompanyLocation findByLocation(@Param("city")String city, @Param("state")String state);
}
