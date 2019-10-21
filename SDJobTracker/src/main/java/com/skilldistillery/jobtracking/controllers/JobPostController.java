package com.skilldistillery.jobtracking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracking.entities.IndeedListing;
import com.skilldistillery.jobtracking.services.IndeedListingService;


@RestController
@CrossOrigin({ "*", "http:localhost:6969" })
public class JobPostController {
	@Autowired
	private IndeedListingService serv;

	@RequestMapping(path = "/jobs", method = RequestMethod.GET)
	public List<IndeedListing> getJobs() {
		
//		#### Refactor to accept keyword + location as PathVariable / RequestBody ####
		List<IndeedListing> jobs = serv.getJobs("java", "Denver", "CO");
		return jobs;
	}
}
