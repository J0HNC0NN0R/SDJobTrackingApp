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

class MappingTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Contact contact;
	private Application app;
	private Progress progress;

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
		contact = em.find(Contact.class, 1);
		app = em.find(Application.class, 1);
		progress = em.find(Progress.class, 1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		contact = null;
		app = null;
	}

	@Disabled
	@Test
	void mapping_Contact_to_Application_test() {
		assertEquals("Dev", contact.getApplication().getPosition());
		assertEquals("contact name", app.getContacts().get(0).getName());

	}

	@Test
	void mapping_Progress_to_Application_test() {
		assertEquals(3, progress.getApplication().getInterestLevel());
		assertEquals("Phone Interview", app.getProgress().get(1).getState());
	}
}
