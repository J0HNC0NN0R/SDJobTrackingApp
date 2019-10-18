package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.ApplicationNote;
import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.Contact;
import com.skilldistillery.jobtracking.entities.Progress;

public interface ApplicationService {

	Application findByApplicationId(Integer id);

	List<Application> getStudentApplications(Integer id);

	Application create(Application application);

	Application update(Application application);

	Progress addProgressOnApplication(Progress progress, Integer appId);
	
	Contact addContactOnApplication(Contact contact, Integer appId);
	
	ApplicationNote addAppNoteOnApplication(ApplicationNote applicationnote, Integer appId);

	
}
