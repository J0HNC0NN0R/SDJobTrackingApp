package com.skilldistillery.jobtracking.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StudentDesiredLocationTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private StudentDesiredLocation dL;

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
		dL = em.find(StudentDesiredLocation.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dL = null;
	}
	//@Disabled
	@Test
	void test() {
		assertEquals(1, dL.getId());
		assertNotNull(dL);
	}
}
