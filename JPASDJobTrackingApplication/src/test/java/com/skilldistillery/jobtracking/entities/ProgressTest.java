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

class ProgressTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
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
		progress = em.find(Progress.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		progress = null;
	}

	@Test
	void test() {
		assertEquals(1, progress.getId());
		assertNotNull(progress);
	}


}
