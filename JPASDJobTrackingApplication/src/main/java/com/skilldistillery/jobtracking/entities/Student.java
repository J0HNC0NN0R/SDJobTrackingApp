package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String email;
	@Column(name="cohort_id")
	private int cohortId;
	private boolean isVettec;
	private boolean isEmployed;
	private String clearance;
	@Column(name="education_level")
	private String educationLevel;
	@Column(name="open_to_relocation")
	private boolean relocation;
	@Column(name="home_of_record")
	private String homeOfRecord;
	@Column(name="desired_locations")
	private String desiredLocations;
	private String role;
	private boolean enabled;
	private String password;

	public Student() {}

	public Student(int id, String firstName, String lastName, String email, int cohortId, boolean isVettec,
			boolean isEmployed, String clearance, String educationLevel, boolean relocation, String homeOfRecord,
			String desiredLocations, String role, boolean enabled, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cohortId = cohortId;
		this.isVettec = isVettec;
		this.isEmployed = isEmployed;
		this.clearance = clearance;
		this.educationLevel = educationLevel;
		this.relocation = relocation;
		this.homeOfRecord = homeOfRecord;
		this.desiredLocations = desiredLocations;
		this.role = role;
		this.enabled = enabled;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCohortId() {
		return cohortId;
	}

	public void setCohortId(int cohortId) {
		this.cohortId = cohortId;
	}

	public boolean isVettec() {
		return isVettec;
	}

	public void setVettec(boolean isVettec) {
		this.isVettec = isVettec;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public boolean isRelocation() {
		return relocation;
	}

	public void setRelocation(boolean relocation) {
		this.relocation = relocation;
	}

	public String getHomeOfRecord() {
		return homeOfRecord;
	}

	public void setHomeOfRecord(String homeOfRecord) {
		this.homeOfRecord = homeOfRecord;
	}

	public String getDesiredLocations() {
		return desiredLocations;
	}

	public void setDesiredLocations(String desiredLocations) {
		this.desiredLocations = desiredLocations;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", cohortId=");
		builder.append(cohortId);
		builder.append(", isVettec=");
		builder.append(isVettec);
		builder.append(", isEmployed=");
		builder.append(isEmployed);
		builder.append(", clearance=");
		builder.append(clearance);
		builder.append(", educationLevel=");
		builder.append(educationLevel);
		builder.append(", relocation=");
		builder.append(relocation);
		builder.append(", homeOfRecord=");
		builder.append(homeOfRecord);
		builder.append(", desiredLocations=");
		builder.append(desiredLocations);
		builder.append(", role=");
		builder.append(role);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}