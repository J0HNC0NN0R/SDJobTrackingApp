package com.skilldistillery.jobtracking.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MappingTestsForApplication {

// F I E L D S

	private static EntityManagerFactory emf;
	private EntityManager em;

	private Contact contact;
	private Application app;
	private Progress progress;
	private ApplicationNote appNote;
	private Company company;
	private Student student;

//--------------------------------------------------------------------------------------------------------

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

		// C O N T A C T
		contact = em.find(Contact.class, 1);

		// A P P L I C A T I O N
		app = em.find(Application.class, 1);

		// P R O G R E S S
		progress = em.find(Progress.class, 1);

		// A P P L I C A T I O N - N O T E
		appNote = em.find(ApplicationNote.class, 1);

		// C O M P A N Y
		company = em.find(Company.class, 1);

		// S T U D E N T
		student = em.find(Student.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();

		// C O N T A C T
		contact = null;

		// A P P L I C A T I ON
		app = null;

		// P R O G R E S S
		progress = null;

		// A P P L I C A T I O N - N O T E
		appNote = null;

		// C O M P A N Y
		company = null;

		// S T U D E N T
		student = null;

	}

	// CONTACT TO APPLICATION TESTS
	@Test
	void mapping_Contact_To_Application_Tests() {
		assertEquals("Dev", contact.getApplication().getPosition());
		assertEquals("contact name", app.getContacts().get(0).getName());

	}

	// PROGRESS TO APPLICATION TESTS
	@Test
	void mapping_Progress_To_Application_Tests() {
		assertEquals(3, progress.getApplication().getInterestLevel());
		assertEquals("Phone Interview", app.getProgress().get(1).getState());

	}

	// APPLICATION_NOTE TO APPLICATION TESTS
	@Test
	void mapping_Application_Note_To_Application_Tests() {
		assertEquals(1, appNote.getApplication().getId());
		assertEquals("I need a job", app.getApplicationNotes().get(0).getBody());

	}

	// COMPANY TO APPLICATION TESTS
	@Test
	void mapping_Company_To_Application_Tests() {
		assertEquals(1, company.getApplications().get(0).getId());
		assertEquals("Fake Company", app.getCompany().getName());

	}

	@Test
	void mapping_Student_To_Application_Tests() {
		assertEquals("Dev", student.getApplications().get(0).getPosition());
		assertEquals("High School", app.getStudent().getEducationLevel());

	}

//--------------------------------------------------------------------------------------------------------

}