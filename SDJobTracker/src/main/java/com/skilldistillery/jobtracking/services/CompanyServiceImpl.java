package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.CompanyLocation;
import com.skilldistillery.jobtracking.repositories.CompanyLocationRepository;
import com.skilldistillery.jobtracking.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository comrepo;
	
	@Autowired
	private CompanyLocationRepository comlocrepo;
	
	@Override
	public Company findByName(String name) {
		return comrepo.findByName(name);
	}
	
	@Override
	public List<Company> findallCompanies(){
		return comrepo.findAll();
	}
	
	@Override
	public Company findByCompanyId(Integer id) {
		return comrepo.findById(id).get();
	}
	
	
	@Override
	public Company create(Company company) {
		Company newCompany = null;
		if (company != null) {
			 newCompany = comrepo.saveAndFlush(company);
		}
		return newCompany;
	}

	

	@Override
	public CompanyLocation addCompanyLocation(CompanyLocation companyLocation, Integer companyId) {
		CompanyLocation newLocation = null;
		Optional<Company> company = comrepo.findById(companyId);
		if(companyLocation != null) {
			companyLocation.setCompany(company.get());
			newLocation = comlocrepo.saveAndFlush(companyLocation);
		}
			
		
		return newLocation;
	}

	@Override
	public CompanyLocation updateCompanyLocation(Integer companyLocId) {

		
		return null;
	}

	@Override
	public CompanyLocation findByCityAndState(String city, String state) {
		return comlocrepo.findByLocation(city, state);
	}
}
