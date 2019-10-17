package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company_note")
public class CompanyNote {
	
	// F I E L D S
	
	@Id
	private int id;
	
	@Column(name="company_id")
	private int companyId;
	
	private String city;
	
	private String state;
	
	// C O N S T R U C T O R S

	public CompanyNote(int id, int companyId, String city, String state) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.city = city;
		this.state = state;
	}
	
	// M E T H O D S

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		CompanyNote other = (CompanyNote) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CompanyNote [id=");
		builder.append(id);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}

}