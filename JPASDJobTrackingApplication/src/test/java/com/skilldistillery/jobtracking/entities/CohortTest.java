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
import org.junit.jupiter.api.Test;

class CohortTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Cohort cohort;

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
		cohort = em.find(Cohort.class, 22);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cohort = null;
	}

	@Test
	void test_Cohort_entity_mapping() {
		System.out.println(cohort);
		assertEquals(22, cohort.getId());
		assertNotNull(cohort);

	}

}
