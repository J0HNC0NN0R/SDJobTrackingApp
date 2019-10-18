package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Cohort;
import com.skilldistillery.jobtracking.entities.CompanyNote;
import com.skilldistillery.jobtracking.entities.Event;
import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.StudentAddress;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.CohortRepository;
import com.skilldistillery.jobtracking.repositories.CompanyNoteRepository;
import com.skilldistillery.jobtracking.repositories.EventRepository;
import com.skilldistillery.jobtracking.repositories.StudentRepository;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sturepo;

	@Autowired
	private CompanyNoteRepository comnoterepo;

	@Autowired
	private CohortRepository cohorepo;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private EventRepository evenrepo;

	@Override
	public Student findByUserName(String username) {

		return sturepo.findByUserame(username);
	}

	@Override
	public List<Student> index() {
		return sturepo.findAll();
	}

	@Override
	public Cohort findById(Integer cohortId) {
		return cohorepo.findById(cohortId).get();

	}

	@Override
	public List<Cohort> getCohorts() {
		return cohorepo.findAll();
	}

	@Override
	public Student findByStudentId(Integer id) {
		return sturepo.findById(id).get();
	}
	


	@Override
	public Student create(Student student, User user, Integer cohortId) {
		Student newStudent = null;
		Cohort newCohort = null;
		
		if (student != null && user != null) {
			newCohort = cohorepo.findById(cohortId).get();
			User newUser = userrepo.saveAndFlush(user);
			student.setUser(user);
			student.setCohort(newCohort);
			newStudent = sturepo.saveAndFlush(student);

		}
		return newStudent;

	}

	@Override
	public Student update(Student student, Integer studentId, Integer cohortId) {
		
		Optional<Student> managedStudent = sturepo.findById(studentId);
		if(managedStudent.isPresent()) {
			Student actualStudent = managedStudent.get();
			actualStudent.setAccepted(student.isAccepted());
			actualStudent.setFirstName(student.getFirstName());
			actualStudent.setLastName(student.getLastName());
			actualStudent.setEmail(student.getEmail());
			actualStudent.setGithubUsername(student.getGithubUsername());
			actualStudent.setGIBill(student.isGIBill());
			actualStudent.setVettec(student.isVettec());
			actualStudent.setEmployed(student.isEmployed());
			actualStudent.setDeposit_paid(student.isDeposit_paid());
			actualStudent.setNeedsLoanerLaptop(student.isNeedsLoanerLaptop());
			actualStudent.setEducationLevel(student.getEducationLevel());
			actualStudent.setOpenToRelocation(student.getOpenToRelocation());
			actualStudent.setClearance(student.getClearance());
			actualStudent.setCohort(cohorepo.findById(cohortId).get());
			
			sturepo.saveAndFlush(actualStudent);
		}
		
		return student;

	}

	@Override
	public Event addEvent(Event event) {
		Event newEvent = null;

		if (event != null) {
			newEvent = evenrepo.saveAndFlush(event);
		}
		return newEvent;
	}

	@Override
	public Event updateEvent(Integer eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByStudentId(Integer studentId) {

		return evenrepo.findByStudentId(studentId);
	}

	@Override
	public CompanyNote getCompanyNote(String companyName, Integer studentId) {
		return comnoterepo.getCompanyNote(companyName, studentId);
	}

	@Override
	public CompanyNote addCompanyNote(Integer companyId, Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompanyNote updateCompanyNote(Integer cNoteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentAddress addStudentAddress(StudentAddress address, Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentAddress updateStudentAddress(Integer addressId) {
		return null;
	}

	@Override
	public List<Student> getStudentsByCohortId(Integer cohortId) {
		return sturepo.findByCohortId(cohortId);

	}

	@Override
	public List<Student> getStudentsByName(String name) {
		return sturepo.findByName(name);
	}

}
