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
import com.skilldistillery.jobtracking.repositories.ApplicationNoteRepository;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;
import com.skilldistillery.jobtracking.repositories.CompanyRepository;
import com.skilldistillery.jobtracking.repositories.ContactRepository;
import com.skilldistillery.jobtracking.repositories.ProgressRepository;
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
	
	@Autowired
	private ApplicationNoteRepository appnoterepo;
	
	@Autowired
	private ProgressRepository progrepo;
	
	@Override
	public Application findByApplicationId(Integer id) {
		
		return apprepo.findById(id).get();
	}
	
	@Override
	public List<Application> getStudentApplications(Integer id){
		return apprepo.findApplicationsByStudentId(id);
	}
	
	@Override
	public Application create(Application application, Integer studentId) {
		Application newApplication = null;
		Optional<Student> foundStudent = sturepo.findById(studentId);
		if(application != null) {
			application.setStudent(foundStudent.get());
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
		Progress newProgress = null;
		Optional<Application> newApplication = apprepo.findById(appId);
		if(progress != null) {
			
			progress.setApplication(newApplication.get());
			newProgress = progrepo.saveAndFlush(progress);
		}
		return newProgress;
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
	public ApplicationNote addAppNoteOnApplication(ApplicationNote applicationNote, Integer appId) {
		ApplicationNote newAppNote = null;
		Optional<Application> newApplication = apprepo.findById(appId);
		if(applicationNote != null){
			
			applicationNote.setApplicationId(newApplication.get());
			newAppNote = appnoterepo.saveAndFlush(applicationNote);
		}
		
		return newAppNote;
	}

	
	
}
