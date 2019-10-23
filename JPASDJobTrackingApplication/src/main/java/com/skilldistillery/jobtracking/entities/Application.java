package com.skilldistillery.jobtracking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String position;
	@Column(name = "desc_url")
	private String descriptionURL;
	@Column(name = "interest_level")
	private int interestLevel;
	@OneToMany(mappedBy = "application")
	private List<Progress> progress;
	@OneToMany(mappedBy = "application")
	private List<Contact> contacts;
	@OneToMany(mappedBy = "application")
	private List<ApplicationNote> applicationNotes;
	@ManyToOne
//	@Column(name = "student_id")
//	private int studentId;
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
//	@Column(name = "company_id")
//	private int companyId;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;

	public Application() {

	}

	public Application(int id, String position, String descriptionURL, int interestLevel, List<Progress> progress,
			List<Contact> contacts, List<ApplicationNote> applicationNotes, Student student, Company company) {
		super();
		this.id = id;
		this.position = position;
		this.descriptionURL = descriptionURL;
		this.interestLevel = interestLevel;
		this.progress = progress;
		this.contacts = contacts;
		this.applicationNotes = applicationNotes;
		this.student = student;
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

	public String getDescriptionURL() {
		return descriptionURL;
	}

	public void setDescriptionURL(String descriptionURL) {
		this.descriptionURL = descriptionURL;
	}

	public int getInterestLevel() {
		return interestLevel;
	}

	public void setInterestLevel(int interestLevel) {
		this.interestLevel = interestLevel;
	}

	public List<Progress> getProgress() {
		return progress;
	}

	public void setProgress(List<Progress> progress) {
		this.progress = progress;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<ApplicationNote> getApplicationNotes() {
		return applicationNotes;
	}

	public void setApplicationNotes(List<ApplicationNote> applicationNotes) {
		this.applicationNotes = applicationNotes;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
		Application other = (Application) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}