package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.repositories.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository apprepo;
	
	
	
	@Override
	public Application findByApplicationId(Integer id) {
		
		return apprepo.findById(id);
	}
	
	@Override
	public List<Application> index(){
		return apprepo.findAll();
	}
	
	@Override
	public Application create(Application application, Integer id) {
		if(application != null) {
			// TODO add application to user using find user by id
			
		}
	}
	
	@Override
	public Application update(Application application) {
		//TODO
	}

	
	
}
