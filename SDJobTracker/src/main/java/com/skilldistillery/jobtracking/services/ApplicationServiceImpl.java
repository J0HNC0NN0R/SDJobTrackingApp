package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.ApplicationNote;
import com.skilldistillery.jobtracking.entities.Company;
import com.skilldistillery.jobtracking.entities.Contact;
import com.skilldistillery.jobtracking.entities.Progress;
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
	public Application create(Application application,Company company, Integer id) {
		// check if company
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

	@Override
	public Progress addProgressOnApplication(Progress progress, Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact addContactOnApplication(Contact contact, Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationNote addAppNoteOnApplication(ApplicationNote applicationnote, Integer appId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
