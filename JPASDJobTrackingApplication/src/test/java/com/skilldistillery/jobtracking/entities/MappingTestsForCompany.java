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

class MappingTestsForCompany {

	// F I E L D S

	private static EntityManagerFactory emf;
	private EntityManager em;

	private JobPost jobPost;
	private CompanyLocation companyLocation;
	private Company company;
	private CompanyNote companyNote;

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

		jobPost = em.find(JobPost.class, 1);
		companyLocation = em.find(CompanyLocation.class, 1);
		company = em.find(Company.class, 1);
		companyNote = em.find(CompanyNote.class, 1);

	}

	@AfterEach
	void tearDown() throws Exception {
		jobPost = null;
		companyLocation = null;
		company = null;
		companyNote = null;

	}

	@Test
	void mapping_Job_Post_To_Company_Tests() {
		// assertEquals(1, jobPost.getCompanyId());
		assertEquals("Dev", jobPost.getPosition());
	}

	@Test
	void mapping_Company_Location_To_Company_Tests() {
		assertEquals(1, companyLocation.getId());
		assertEquals("Denver", companyLocation.getCity());

	}
	@Disabled
	@Test
	void mapping_Company_Note_To_Company_Tests() {
		assertEquals(1, companyNote.getId());
		//assertEquals(, companyNote.getBody());
	}

}
