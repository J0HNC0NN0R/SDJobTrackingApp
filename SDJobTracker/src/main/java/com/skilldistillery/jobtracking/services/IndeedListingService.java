package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.IndeedListing;

public interface IndeedListingService {

	List<IndeedListing> getJobs(String keyword, String city, String state);

}
