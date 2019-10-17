package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository apprepo;
	
	
	
	@Override
	public Application findByApplicationId(Integer id) {
		
		return apprepo.findById(id).get();
	}
	
	@Override
	public List<Application> getStudentApplications(Integer id){
		return apprepo.findApplicationsByStudentId(id);
	}
	
	@Override
	public Application create(Application application, Integer id) {
		if(application != null) {
			// TODO add application to user using find user by id
			
		}
		return application;
	}
	
	@Override
	public Application update(Application application) {
		return application;
		//TODO
	}

	
	
}
