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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@Column(name = "user_id")
//	private int userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "github_username")
	private String githubUsername;
	@Column(name = "is_vettec")
	private boolean isVettec;
	@Column(name = "is_gi_bill")
	private boolean isGIBill;
	@Column(name = "is_employed")
	private boolean isEmployed;
	@Column(name = "is_accepted")
	private boolean isAccepted;
	@Column(name = "deposit_paid")
	private boolean depositPaid;
	@Column(name = "needs_loaner_laptop")
	private boolean needsLoanerLaptop;
	@Column(name = "education_level")
	private String educationLevel;
	@Column(name = "open_to_relocation")
	private boolean openToRelocation;
	private String clearance;
	@OneToMany(mappedBy = "student")
//	@JsonIgnore
	private List<Application> applications;
	@ManyToOne
	@JoinColumn(name = "cohort_id")
	private Cohort cohort;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToMany(mappedBy = "student")
	private List<CompanyNote> companyNotes;
	@OneToMany(mappedBy = "student")
	private List<StudentDesiredLocation> studentDesiredLocations;
	@OneToMany(mappedBy = "student")
	private List<Event> events;
	@OneToMany(mappedBy = "student")
	private List<StudentAddress> address;

	public Student() {

	}

	public Student(String firstName, String lastName, String email, String githubUsername, boolean isVettec,
			boolean isGIBill, boolean isEmployed, boolean isAccepted, boolean depositPaid, boolean needsLoanerLaptop,
			String educationLevel, boolean openToRelocation, String clearance, List<Application> applications,

			Cohort cohort, User user, List<CompanyNote> companyNotes,
			List<StudentDesiredLocation> studentDesiredLocations, List<Event> events, List<StudentAddress> address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.githubUsername = githubUsername;
		this.isVettec = isVettec;
		this.isGIBill = isGIBill;
		this.isEmployed = isEmployed;
		this.isAccepted = isAccepted;
		this.depositPaid = depositPaid;
		this.needsLoanerLaptop = needsLoanerLaptop;
		this.educationLevel = educationLevel;
		this.openToRelocation = openToRelocation;
		this.clearance = clearance;
		this.applications = applications;
		this.cohort = cohort;
		this.user = user;
		this.companyNotes = companyNotes;
		this.studentDesiredLocations = studentDesiredLocations;
		this.events = events;
		this.address = address;
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

	public String getGithubUsername() {
		return githubUsername;
	}

	public void setGithubUsername(String githubUsername) {
		this.githubUsername = githubUsername;
	}

	public boolean isVettec() {
		return isVettec;
	}

	public void setVettec(boolean isVettec) {
		this.isVettec = isVettec;
	}

	public boolean isGIBill() {
		return isGIBill;
	}

	public void setGIBill(boolean isGIBill) {
		this.isGIBill = isGIBill;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}


	public boolean isDepositPaid() {
	

		return depositPaid;
	}

	public void setDeposit_paid(boolean depositPaid) {
		this.depositPaid = depositPaid;
	}

	public boolean isNeedsLoanerLaptop() {
		return needsLoanerLaptop;
	}

	public void setNeedsLoanerLaptop(boolean needsLoanerLaptop) {
		this.needsLoanerLaptop = needsLoanerLaptop;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public boolean isOpenToRelocation() {
		return openToRelocation;
	}

	public void setOpenToRelocation(boolean openToRelocation) {
		this.openToRelocation = openToRelocation;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CompanyNote> getCompanyNotes() {
		return companyNotes;
	}

	public void setCompanyNotes(List<CompanyNote> companyNotes) {
		this.companyNotes = companyNotes;
	}

	public List<StudentDesiredLocation> getStudentDesiredLocations() {
		return studentDesiredLocations;
	}

	public void setStudentDesiredLocations(List<StudentDesiredLocation> studentDesiredLocations) {
		this.studentDesiredLocations = studentDesiredLocations;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<StudentAddress> getAddress() {
		return address;
	}

	public void setAddress(List<StudentAddress> address) {
		this.address = address;
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

	

}