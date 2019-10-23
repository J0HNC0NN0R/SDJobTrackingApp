package com.skilldistillery.jobtracking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "site_url")
	private String siteURL;
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<Application> applications;
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<CompanyNote> companyNote;
	@OneToMany(mappedBy = "company")
	private List<CompanyLocation> companyLocations;
	@OneToMany(mappedBy = "company")
	@JsonIgnore
	private List<JobPost> jopPosts;

	public Company(int id, String name, String siteURL, List<Application> applications, List<CompanyNote> companyNote,
			List<CompanyLocation> companyLocations, List<JobPost> jopPosts) {
		super();
		this.id = id;
		this.name = name;
		this.siteURL = siteURL;
		this.applications = applications;
		this.companyNote = companyNote;
		this.companyLocations = companyLocations;
		this.jopPosts = jopPosts;
	}

	public Company() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSiteURL() {
		return siteURL;
	}

	public void setSiteURL(String siteURL) {
		this.siteURL = siteURL;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<JobPost> getJopPosts() {
		return jopPosts;
	}

	public void setJopPosts(List<JobPost> jopPosts) {
		this.jopPosts = jopPosts;
	}

	public List<CompanyNote> getCompanyNote() {
		return companyNote;
	}

	public void setCompanyNote(List<CompanyNote> companyNote) {
		this.companyNote = companyNote;
	}

	public List<CompanyLocation> getCompanyLocations() {
		return companyLocations;
	}

	public void setCompanyLocations(List<CompanyLocation> companyLocations) {
		this.companyLocations = companyLocations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}