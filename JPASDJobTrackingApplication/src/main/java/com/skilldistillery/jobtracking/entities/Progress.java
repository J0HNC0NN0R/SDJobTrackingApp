package com.skilldistillery.jobtracking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Progress {

	// F I E L D S

	@Id
	private int id;

	@Column(name = "application_id")
	private int applicationId;

	private String State;

	@Column(name = "updated_date")
	private Date updatedDate;

	// C O N S T R U C T O R S

	public Progress(int id, int applicationId, String state, Date updatedDate) {
		super();
		this.id = id;
		this.applicationId = applicationId;
		State = state;
		this.updatedDate = updatedDate;
	}

	// M E T H O D S

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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
		Progress other = (Progress) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Progress [id=");
		builder.append(id);
		builder.append(", applicationId=");
		builder.append(applicationId);
		builder.append(", State=");
		builder.append(State);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append("]");
		return builder.toString();
	}

}