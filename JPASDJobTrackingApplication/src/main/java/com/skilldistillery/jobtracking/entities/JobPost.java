package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_post")
public class JobPost {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "company_id")
	private int companyId;
	private String position;

	private String description;

	@Column(name = "post_url")
	private String postURL;

	public JobPost(int id, int companyId, String position, String description, String postURL) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.position = position;
		this.description = description;
		this.postURL = postURL;
	}

	public JobPost() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JobPost [id=");
		builder.append(id);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", position=");
		builder.append(position);
		builder.append(", description=");
		builder.append(description);
		builder.append(", postURL=");
		builder.append(postURL);
		builder.append("]");
		return builder.toString();
	}

}