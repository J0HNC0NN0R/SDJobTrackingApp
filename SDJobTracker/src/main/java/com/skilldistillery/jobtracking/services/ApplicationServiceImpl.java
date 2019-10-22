package com.skilldistillery.jobtracking.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Application;
import com.skilldistillery.jobtracking.entities.ApplicationNote;
import com.skilldistillery.jobtracking.entities.Contact;
import com.skilldistillery.jobtracking.entities.Progress;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.repositories.ApplicationNoteRepository;
import com.skilldistillery.jobtracking.repositories.ApplicationRepository;
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
			System.err.println(newApplication);
			Progress progress = new Progress(newApplication, "Not Applied", LocalDateTime.now());
			this.addProgressOnApplication(progress, newApplication.getId());
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
			actualApplication.setCompany(application.getCompany());
			apprepo.saveAndFlush(actualApplication);
		
	}
		return actualApplication;
	}
	
	@Override
	public Progress getProgressById(Integer progressId) {
		return progrepo.findById(progressId).get();
	}
	
	@Override 
	public List<Progress> getAllProgressByAppId(Integer appId){
		return progrepo.findByApplicationId(appId);
	}

	@Override
	public Progress addProgressOnApplication(Progress progress, Integer appId) {
		Progress newProgress = new Progress();
		
		try {
		
			Progress managed = progrepo.findByApplicationId(appId).get(0);
			newProgress = updateProgress(progress, managed.getId());
			
		} catch (Exception e) {
		
		
			Optional<Application> newApplication = apprepo.findById(appId);
			if(progress != null) {
				progress.setApplication(newApplication.get());
				newProgress = progrepo.saveAndFlush(progress);
			}
		}
		
		System.err.println(newProgress);
		
		return newProgress;
	}
	
	@Override
	public Progress updateProgress(Progress progress, Integer progId) {
		Progress actualProgress = null;
		Optional<Progress> managedProgress = progrepo.findById(progId);

		if(managedProgress.isPresent()) {
			actualProgress = managedProgress.get();
			actualProgress.setState(progress.getState());
			actualProgress.setUpdated(progress.getUpdated());
			
			progrepo.saveAndFlush(actualProgress);
		}
		
		return actualProgress;
	}
	
	@Override
	public Contact getContactById(Integer contactId) {
		return contrepo.findById(contactId).get();
	}

	@Override
	public List <Contact> getContactsByAppId(Integer appId) {
		return contrepo.findByApplicationId(appId);
	}
	
	@Override
	public Contact addContactOnApplication(Contact contact, Integer appId) {
		
		Contact newContact = null;
		Optional<Application> newApplication = apprepo.findById(appId);
		if(contact !=null) {
			
			contact.setApplication(newApplication.get());
			newContact = contrepo.saveAndFlush(contact);
			
		}
		return newContact;
	}
	
	@Override
	public Contact updateContact(Contact contact, Integer contactId) {
		Contact actualContact = null;
		Optional<Contact> managedContact = contrepo.findById(contactId);
		if(managedContact.isPresent()) {
			actualContact = managedContact.get();
			actualContact.setName(contact.getName());
			actualContact.setEmail(contact.getEmail());
			actualContact.setPhone(contact.getPhone());
			actualContact.setPosition(contact.getPosition());
			
			contrepo.saveAndFlush(actualContact);
		}
		return actualContact;
	}
	
	@Override
	public ApplicationNote getAppNoteById(Integer appNoteId) {
		return appnoterepo.findById(appNoteId).get();
	}
	
	@Override
	public List<ApplicationNote> getAppNotesByAppId(Integer appId){
		return appnoterepo.findByAppId(appId);
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

	@Override
	public ApplicationNote updateApplicationNote(ApplicationNote applicationNote, Integer appNoteId) {
		ApplicationNote actualAppNote = null;
		
		Optional<ApplicationNote> managedAppNote = appnoterepo.findById(appNoteId);
		if(managedAppNote.isPresent()) {
			actualAppNote = managedAppNote.get();
			actualAppNote.setBody(applicationNote.getBody());
			actualAppNote.setTitle(applicationNote.getTitle());
			
			appnoterepo.saveAndFlush(actualAppNote);
		}
		return actualAppNote;
	}
	
}
