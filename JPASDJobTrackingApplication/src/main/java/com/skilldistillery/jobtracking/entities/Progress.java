package com.skilldistillery.jobtracking.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Progress {

	@Id
	private int id;
//	@Column(name = "application_id")
//	private int applicationId;
	@ManyToOne
	@JoinColumn(name = "application_id")
	@JsonIgnore
	private Application application;
	private String State;
	@Column(name = "updated")
	private LocalDateTime updated;


	public Progress(Application application, String state, LocalDateTime updated) {
		super();
		this.application = application;
		State = state;
		this.updated = updated;
	}

	public Progress(int id, Application applicationId, String state, LocalDateTime updated) {
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

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
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

	


}