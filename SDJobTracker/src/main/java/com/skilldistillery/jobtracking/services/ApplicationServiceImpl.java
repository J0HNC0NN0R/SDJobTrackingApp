package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.ApplicationNote;
import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.Contact;
import com.skilldistillery.jobtracking.entities.Progress;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;
import com.skilldistillery.jobtracking.repositories.CompanyRepository;
import com.skilldistillery.jobtracking.repositories.ContactRepository;
import com.skilldistillery.jobtracking.repositories.StudentRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository apprepo;
	
	@Autowired
	private StudentRepository sturepo;
	
	@Autowired 
	private CompanyRepository comrepo;
	
	@Autowired
	private ContactRepository contrepo;
	
	@Override
	public Application findByApplicationId(Integer id) {
		
		return apprepo.findById(id).get();
	}
	
	@Override
	public List<Application> getStudentApplications(Integer id){
		return apprepo.findApplicationsByStudentId(id);
	}
	
	@Override
	public Application create(Application application, Company company, Integer studentId) {
		Application newApplication = null;
		if(application != null) {
			newApplication = apprepo.saveAndFlush(application);
		}
		return newApplication;
	}
	
	@Override
	public Application update(Application application, Integer appId) {
		Application actualApplication = null;
		Optional<Application> managedApplication = apprepo.findById(appId);
		
		if(managedApplication.isPresent()) {
			actualApplication = managedApplication.get();
			actualApplication.setPosition(application.getPosition());
			actualApplication.setDescriptionURL(application.getDescriptionURL());
			actualApplication.setInterestLevel(application.getInterestLevel());
			
			apprepo.saveAndFlush(actualApplication);
		
	}
		return actualApplication;
	}

	@Override
	public Progress addProgressOnApplication(Progress progress, Integer appId) {
		
		return null;
	}

	@Override
	public Contact addContactOnApplication(Contact contact, Integer appId) {
		
		Contact newContact = null;
		Optional<Application> newApplication = apprepo.findById(appId);
		if(contact !=null) {
			
			contact.setApplication(newApplication.get());
			newContact = contrepo.saveAndFlush(contact);
			
		}
		return null;
	}

	@Override
	public ApplicationNote addAppNoteOnApplication(ApplicationNote applicationnote, Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
