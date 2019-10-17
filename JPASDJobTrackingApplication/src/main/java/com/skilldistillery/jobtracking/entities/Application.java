package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "student_id")
	private int studentId;

	@Column(name = "company_id")
	private int companyId;

	private String position;

	@Column(name = "desc_url")
	private String descriptionURL;

	private int interestLevel;

	public Application(int id, int studentId, int companyId, String position, String descriptionURL,
			int interestLevel) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.companyId = companyId;
		this.position = position;
		this.descriptionURL = descriptionURL;
		this.interestLevel = interestLevel;
	}

	public Application() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Application [id=");
		builder.append(id);
		builder.append(", studentId=");
		builder.append(studentId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", position=");
		builder.append(position);
		builder.append(", descriptionURL=");
		builder.append(descriptionURL);
		builder.append(", interestLevel=");
		builder.append(interestLevel);
		builder.append("]");
		return builder.toString();
	}
}