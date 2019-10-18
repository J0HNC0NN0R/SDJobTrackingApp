package com.skilldistillery.jobtracking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name = "site_url")
	private String siteURL;
	@OneToMany(mappedBy="company")
	private Application application;
	@OneToMany(mappedBy="company")
	private List<CompanyNote> companyNote;
	@OneToMany(mappedBy="company")
	private List<CompanyLocation> companyLocations;
	@OneToMany(mappedBy="company")
	private List<JobPost> jopPosts;
	
	public Company() {
		
	}

	public Company(int id, String name, String siteURL, Application application, List<CompanyNote> companyNote,
			List<CompanyLocation> companyLocations) {
		super();
		this.id = id;
		this.name = name;
		this.siteURL = siteURL;
		this.application = application;
		this.companyNote = companyNote;
		this.companyLocations = companyLocations;
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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Company [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", siteURL=");
		builder.append(siteURL);
		builder.append("]");
		return builder.toString();
	}

}