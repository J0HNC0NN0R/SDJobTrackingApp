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

class StudentAddressTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private StudentAddress studentAddress;

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
		studentAddress = em.find(StudentAddress.class, 1);
		System.out.println(studentAddress);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		studentAddress = null;
	}

//	@Disabled
	@Test
	void test_Cohort_entity_mapping() {
		assertEquals(1, studentAddress.getId());
		assertNotNull(studentAddress);
	}
	
}