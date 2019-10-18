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

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_id")
	private int userId;
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
	private boolean deposit_paid;
	@Column(name = "needs_loaner_laptop")
	private boolean needsLoanerLaptop;
	@Column(name = "education_level")
	private String educationLevel;
	@Column(name = "open_to_relocation")
	private String openToRelocation;
	private String clearance;
	@OneToMany(mappedBy="student")
	private Application application;
	@ManyToOne
	@JoinColumn(name="cohort_id")
	private Cohort cohort;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(mappedBy="student")
	private List<CompanyNote> companyNotes;
	@OneToMany(mappedBy="student")
	private List<StudentDesiredLocation> studentDesiredLocations;
	@OneToMany(mappedBy="student")
	private List<Event> events;
	@OneToMany(mappedBy="student")
	private List<StudentAddress> address;
	
	
	public Student() {
		
	}
	
	public Student(int id, int userId, String firstName, String lastName, String email, String githubUsername,
			boolean isVettec, boolean isGIBill, boolean isEmployed, boolean isAccepted, boolean deposit_paid,
			boolean needsLoanerLaptop, String educationLevel, String openToRelocation, String clearance,
			Application application, Cohort cohort, User user, List<CompanyNote> companyNotes) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.githubUsername = githubUsername;
		this.isVettec = isVettec;
		this.isGIBill = isGIBill;
		this.isEmployed = isEmployed;
		this.isAccepted = isAccepted;
		this.deposit_paid = deposit_paid;
		this.needsLoanerLaptop = needsLoanerLaptop;
		this.educationLevel = educationLevel;
		this.openToRelocation = openToRelocation;
		this.clearance = clearance;
		this.application = application;
		this.cohort = cohort;
		this.user = user;
		this.companyNotes = companyNotes;
	}

	public Student(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isDeposit_paid() {
		return deposit_paid;
	}

	public void setDeposit_paid(boolean deposit_paid) {
		this.deposit_paid = deposit_paid;
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

	public String getOpenToRelocation() {
		return openToRelocation;
	}

	public void setOpenToRelocation(String openToRelocation) {
		this.openToRelocation = openToRelocation;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	public List<CompanyNote> getCompanyNotes() {
		return companyNotes;
	}

	public void setCompanyNotes(List<CompanyNote> companyNotes) {
		this.companyNotes = companyNotes;
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
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", githubUsername=");
		builder.append(githubUsername);
		builder.append(", isVettec=");
		builder.append(isVettec);
		builder.append(", isGIBill=");
		builder.append(isGIBill);
		builder.append(", isEmployed=");
		builder.append(isEmployed);
		builder.append(", isAccepted=");
		builder.append(isAccepted);
		builder.append(", deposit_paid=");
		builder.append(deposit_paid);
		builder.append(", needsLoanerLaptop=");
		builder.append(needsLoanerLaptop);
		builder.append(", educationLevel=");
		builder.append(educationLevel);
		builder.append(", openToRelocation=");
		builder.append(openToRelocation);
		builder.append(", clearance=");
		builder.append(clearance);
		builder.append("]");
		return builder.toString();
	}

}