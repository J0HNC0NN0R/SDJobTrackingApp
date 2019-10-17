package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;
import com.skilldistillery.jobtracking.repositories.StudentRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository apprepo;
	
	@Autowired
	private StudentRepository sturepo;
	
	
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
			Student student = sturepo.findById(id).get();
			// set student application.setUserId();
			Application app = apprepo.saveAndFlush(application);
		}
		return application;
	}
	
	@Override
	public Application update(Application application) {
		return application;
		//TODO
	}

	
	
}
