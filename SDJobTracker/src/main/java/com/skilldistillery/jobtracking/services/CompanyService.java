package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.CompanyLocation;

public interface CompanyService {

	List<Company> findallCompanies();

	Company findByCompanyId(Integer id);

	Company create(Company company);
	
	
	CompanyLocation addCompanyLocation(CompanyLocation companyLocation, Integer companyId);

	
	CompanyLocation updateCompanyLocation(Integer companyLocId);

	Company findByName(String name);

	CompanyLocation findByCityAndState(String city, String state);
	
	
	
	
}
