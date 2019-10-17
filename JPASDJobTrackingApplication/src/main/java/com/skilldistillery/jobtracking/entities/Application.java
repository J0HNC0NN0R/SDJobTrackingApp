package com.skilldistillery.jobtracking.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Application {

	// F I E L D S

	@Id
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "company_id")
	private int companyId;

	@Column(name = "notes_id")
	private int notesId;

	private String position;

	@Column(name = "desc_url")
	private String describeURL;

	@Column(name = "date_applied")
	private Date dateApplied;

	private int interestLevel;

	// C O N S T R U C T O R S

	public Application(int id, int userId, int companyId, int notesId, String position, String describeURL,
			Date dateApplied, int interestLevel) {
		super();
		this.id = id;
		this.userId = userId;
		this.companyId = companyId;
		this.notesId = notesId;
		this.position = position;
		this.describeURL = describeURL;
		this.dateApplied = dateApplied;
		this.interestLevel = interestLevel;
	}

	// M E T H O D S

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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getNotesId() {
		return notesId;
	}

	public void setNotesId(int notesId) {
		this.notesId = notesId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescribeURL() {
		return describeURL;
	}

	public void setDescribeURL(String describeURL) {
		this.describeURL = describeURL;
	}

	public Date getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(Date dateApplied) {
		this.dateApplied = dateApplied;
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
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", notesId=");
		builder.append(notesId);
		builder.append(", position=");
		builder.append(position);
		builder.append(", describeURL=");
		builder.append(describeURL);
		builder.append(", dateApplied=");
		builder.append(dateApplied);
		builder.append(", interestLevel=");
		builder.append(interestLevel);
		builder.append("]");
		return builder.toString();
	}

}
