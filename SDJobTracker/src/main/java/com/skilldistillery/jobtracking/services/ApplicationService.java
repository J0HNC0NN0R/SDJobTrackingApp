package com.skilldistillery.jobtracking.services;

import java.util.List;

public interface ApplicationService {

	Application findByApplicationId(Integer id);

	List<Application> index();

	Application create(Application application, Integer id);
}
