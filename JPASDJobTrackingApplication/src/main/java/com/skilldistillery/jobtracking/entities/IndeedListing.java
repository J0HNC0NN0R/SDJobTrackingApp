package com.skilldistillery.jobtracking.entities;

public class IndeedListing {
	private String title;
	private String company;
	private String location;
	private String description;
	private String url;

	public IndeedListing() {
	}

	public IndeedListing(String title, String company, String location, String description, String url) {
		super();
		this.title = title;
		this.company = company;
		this.location = location;
		this.description = description;
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}