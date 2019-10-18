package com.skilldistillery.jobtracking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Progress {

	@Id
	private int id;
//	@Column(name = "application_id")
//	private int applicationId;
	@ManyToOne
	@JoinColumn(name = "application_id")
	private Application application;
	private String State;
	@Column(name = "updated")
	private Date updated;

	public Progress(int id, Application applicationId, String state, Date updated) {
		super();
		this.id = id;
		this.application = applicationId;
		State = state;
		this.updated = updated;
	}

	public Progress() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
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
//		builder.append(", application=");
//		builder.append(application);
		builder.append(", State=");
		builder.append(State);
		builder.append(", updated=");
		builder.append(updated);
		builder.append("]");
		return builder.toString();
	}


}