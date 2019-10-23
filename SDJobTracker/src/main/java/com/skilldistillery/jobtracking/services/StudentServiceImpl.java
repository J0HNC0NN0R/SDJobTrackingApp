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
import com.skilldistillery.jobtracking.repositories.CompanyRepository;
import com.skilldistillery.jobtracking.repositories.EventRepository;
import com.skilldistillery.jobtracking.repositories.StudentAddressRepository;
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
	
	@Autowired
	private CompanyRepository comrepo;
	
	@Autowired 
	private StudentAddressRepository stuaddrepo;

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
	public Cohort addCohort(Cohort cohort) {
		Cohort newCohort = null;
		if(cohort != null) {
			newCohort = cohorepo.saveAndFlush(cohort);
		}
		return newCohort;
	}
	
	@Override
	public Cohort updateCohort(Cohort cohort, Integer cohortId) {
		Cohort actualCohort = null;
		
		Optional<Cohort> managedCohort = cohorepo.findById(cohortId);
		if(managedCohort.isPresent()) {
			actualCohort = managedCohort.get();
			actualCohort.setName(cohort.getName());
			actualCohort.setNickname(cohort.getNickname());
			actualCohort.setStartDate(cohort.getStartDate().plusDays(1));
			actualCohort.setEndDate(cohort.getEndDate().plusDays(1));
			cohorepo.saveAndFlush(actualCohort);
		}
		return actualCohort;
	}

	@Override
	public Student create(Student student, User user, Integer cohortId) {
		System.err.println("impl: " + student);
		Student newStudent = null;
		Cohort newCohort = null;
		
		if (student != null && user != null) {
			newCohort = cohorepo.findById(cohortId).get();
			User newUser = userrepo.saveAndFlush(user);
			student.setUser(newUser);
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
			actualStudent.setDeposit_paid(student.isDepositPaid());
			actualStudent.setNeedsLoanerLaptop(student.isNeedsLoanerLaptop());
			actualStudent.setEducationLevel(student.getEducationLevel());
			actualStudent.setOpenToRelocation(student.isOpenToRelocation());
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
	public Event updateEvent(Event event, Integer eventId) {
		Event actualEvent = null;
		Optional<Event> managedEvent = evenrepo.findById(eventId);
		if(managedEvent.isPresent()) {
			actualEvent = managedEvent.get();
			actualEvent.setTitle(event.getTitle());
			actualEvent.setDescription(event.getDescription());
			actualEvent.setLocation(event.getLocation());
			actualEvent.setDate(event.getDate());
			
			evenrepo.saveAndFlush(actualEvent);
		}
		
		return actualEvent;
	}

	@Override
	public List<Event> getEventsByStudentId(Integer studentId) {

		return evenrepo.findByStudentId(studentId);
	}

	@Override
	public CompanyNote getCompanyNote(Integer companyId, Integer studentId) {
		return comnoterepo.getCompanyNote(companyId, studentId);
	}

	@Override
	public CompanyNote addCompanyNote(CompanyNote companynote, Integer companyId, Integer studentId) {
		CompanyNote newCNote = null;
		
		if (companynote != null) {
			
			companynote.setCompany(comrepo.findById(companyId).get());
			companynote.setStudent(sturepo.findById(studentId).get());
			newCNote = comnoterepo.saveAndFlush(companynote);
		}
		return newCNote;
	}

	@Override
	public CompanyNote updateCompanyNote(CompanyNote companynote, Integer cNoteId) {
		CompanyNote actualCNote = null;
		Optional<CompanyNote> managedCNote = comnoterepo.findById(cNoteId);
		if(managedCNote.isPresent()) {
			 actualCNote = managedCNote.get();
			actualCNote.setBody(companynote.getBody());
			actualCNote.setTitle(companynote.getTitle());
			comnoterepo.saveAndFlush(actualCNote);
		}
		return actualCNote;
	}

	@Override
	public StudentAddress getAddressById(Integer stuAddId) {
		return stuaddrepo.findById(stuAddId).get();
	}
		
	@Override
	public List<StudentAddress> getAddressesByStudentId(Integer studentId){
		return stuaddrepo.findByStudentId(studentId);
	}
	@Override
	public StudentAddress addStudentAddress(StudentAddress address, Integer studentId) {
		StudentAddress newAddress = null;
		
		if(address != null) {
			Student newStudent = sturepo.findById(studentId).get();
			address.setStudent(newStudent);
			newAddress = stuaddrepo.saveAndFlush(address);
		}
		return newAddress;
	}

	@Override
	public StudentAddress updateStudentAddress(StudentAddress address, Integer addressId) {
		StudentAddress actualAddress = null;
		Optional<StudentAddress> managedAddress = stuaddrepo.findById(addressId);
		if(managedAddress.isPresent()) {
			actualAddress = managedAddress.get();
			actualAddress.setStreet(address.getStreet());
			actualAddress.setCity(address.getCity());
			actualAddress.setState(address.getState());
			actualAddress.setZipcode(address.getZipcode());
			actualAddress.setPhone(address.getPhone());
			stuaddrepo.saveAndFlush(actualAddress);
		}
		return actualAddress;
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
