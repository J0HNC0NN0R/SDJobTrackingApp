package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "job_post")
public class JobPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String position;
	private String description;
	@Column(name = "post_url")
	private String postURL;
//	@Column(name = "company_id")
//	private int companyId;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	public JobPost() {
		
	}
	
	public JobPost(int id, String position, String description, String postURL, Company company) {
		super();
		this.id = id;
		this.position = position;
		this.description = description;
		this.postURL = postURL;
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostURL() {
		return postURL;
	}

	public void setPostURL(String postURL) {
		this.postURL = postURL;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
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
		JobPost other = (JobPost) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	
	
	
}