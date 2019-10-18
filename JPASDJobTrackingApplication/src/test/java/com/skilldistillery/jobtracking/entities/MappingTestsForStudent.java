package com.skilldistillery.jobtracking.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MappingTestsForStudent {

	private static EntityManagerFactory emf;
	private EntityManager em;

	private Student student;
	private Cohort cohort;
	private User user;
	private Event event;
	private StudentAddress studentAddress;
	private StudentDesiredLocation studentDesiredLocation;
	private CompanyNote companyNote;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("trackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();

	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();

		student = em.find(Student.class, 1);
		cohort = em.find(Cohort.class, 22);
		user = em.find(User.class, 1);
		event = em.find(Event.class, 1);
		studentAddress = em.find(StudentAddress.class, 1);
		studentDesiredLocation = em.find(StudentDesiredLocation.class, 1);
		companyNote = em.find(CompanyNote.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();

		student = null;
		cohort = null;
		user = null;
		event = null;
		studentAddress = null;
		studentDesiredLocation = null;
		companyNote = null;

	}

	@Test
	void mapping_Cohort_To_Student_Tests() {
		assertEquals("Test", cohort.getStudents().get(0).getFirstName());
		assertEquals(22, student.getCohort().getId());

	}

	@Test
	void mapping_User_To_Student_Tests() {
		assertEquals("stu1@test.com", user.getStudent().getEmail());
		assertEquals("test", student.getUser().getUsername());
	}

	@Test
	void mapping_Event_To_Student_Tests() {
		assertEquals("Secret", event.getStudent().getClearance());
		assertEquals("test ev1", student.getEvents().get(0).getTitle());

	}

	@Test
	void mapping_Student_Address_To_Student_Tests() {
		assertEquals("Secret", studentAddress.getStudent().getClearance());
		assertEquals("Denver", student.getAddress().get(0).getCity());
	}

	@Test
	void mapping_Student_Desired_Location_To_Student_Tests() {
		assertEquals("gituser", studentDesiredLocation.getStudent().getGithubUsername());
		assertEquals("CO", student.getStudentDesiredLocations().get(0).getState());
	}

	@Test
	void mapping_Company_Note_To_Student_Tests() {
		assertEquals("Secret", companyNote.getStudent().getClearance());
		assertEquals("Company Note", student.getCompanyNotes().get(0).getTitle());
	}

}
