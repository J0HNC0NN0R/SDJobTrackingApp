package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Application;

public interface ApplicationService {

	Application findByApplicationId(Integer id);

	List<Application> getStudentApplications(Integer id);

	Application create(Application application, Integer id);

	Application update(Application application);


	
}
