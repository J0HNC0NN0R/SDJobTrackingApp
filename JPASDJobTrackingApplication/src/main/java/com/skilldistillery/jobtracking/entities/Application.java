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
		result = prime * result + ((applicatinNotes == null) ? 0 : applicatinNotes.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((contacts == null) ? 0 : contacts.hashCode());
		result = prime * result + ((descriptionURL == null) ? 0 : descriptionURL.hashCode());
		result = prime * result + id;
		result = prime * result + interestLevel;
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((progress == null) ? 0 : progress.hashCode());
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		if (applicatinNotes == null) {
			if (other.applicatinNotes != null)
				return false;
		} else if (!applicatinNotes.equals(other.applicatinNotes))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (descriptionURL == null) {
			if (other.descriptionURL != null)
				return false;
		} else if (!descriptionURL.equals(other.descriptionURL))
			return false;
		if (id != other.id)
			return false;
		if (interestLevel != other.interestLevel)
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (progress == null) {
			if (other.progress != null)
				return false;
		} else if (!progress.equals(other.progress))
			return false;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Application [id=");
		builder.append(id);
		builder.append(", position=");
		builder.append(position);
		builder.append(", descriptionURL=");
		builder.append(descriptionURL);
		builder.append(", interestLevel=");
		builder.append(interestLevel);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", contacts=");
		builder.append(contacts);
		builder.append(", applicationNotes=");
		builder.append(applicationNotes);
		builder.append(", student=");
		builder.append(student);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}
	

}