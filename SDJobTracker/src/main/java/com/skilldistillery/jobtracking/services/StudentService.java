package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.CompanyNote;
import com.skilldistillery.jobtracking.entities.Event;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.StudentAddress;
import com.skilldistillery.jobtracking.entities.User;

public interface StudentService {

	Student findByUserName(String username);

	List<Student> index();

	Student findByStudentId(Integer id);

	Student create(Student student, User user, Integer cohortId);

	Student update(Student student, Integer studentId);

	Event addEvent(Event event);

	Event updateEvent(Integer eventId);

	CompanyNote addCompanyNote(Integer companyId, Integer studentId);

	CompanyNote updateCompanyNote(Integer cNoteId);

	CompanyNote getCompanyNote(String companyName, Integer studentId);

	StudentAddress addStudentAddress(StudentAddress address, Integer studentId);

	StudentAddress updateStudentAddress(Integer addressId);

	Cohort findById(Integer cohortId);

	List<Student> getStudentsByCohortId(Integer cohortId);

	List<Cohort> getCohorts();

	List<Student> getStudentsByName(String name);

	List<Event> getEventsByStudentId(Integer studentId);

	
	
}
