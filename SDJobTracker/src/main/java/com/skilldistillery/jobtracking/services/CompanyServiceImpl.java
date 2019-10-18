package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.CompanyLocation;
import com.skilldistillery.jobtracking.entities.CompanyNote;
import com.skilldistillery.jobtracking.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository comrepo;
	
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
		if (company != null) {
			// TODO add location
			Company newCompany = comrepo.saveAndFlush(company);
		}
		return company;
	}

	

	@Override
	public CompanyLocation addCompanyLocation(Integer companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyLocation updateCompanyLocation(Integer companyLocId) {
		// TODO Auto-generated method stub
		return null;
	}
}
