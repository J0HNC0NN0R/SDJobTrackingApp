package com.skilldistillery.jobtracking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_address")
public class StudentAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street;
	@Column(name="student_id")
	private int studentId;
	@Column(name="company_id")
	private int companyId;
	private String city;
	@Column(name="zip")
	private String zipcode;
	@Column()
	private String phoneNumber;
	private String email;
	
	public StudentAddress() {}

	public StudentAddress(int id, String street, int studentId, int companyId, String city, String zipcode, String phoneNumber,
			String email) {
		super();
		this.id = id;
		this.street = street;
		this.studentId = studentId;
		this.companyId = companyId;
		this.city = city;
		this.zipcode = zipcode;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		StudentAddress other = (StudentAddress) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", street=");
		builder.append(street);
		builder.append(", studentId=");
		builder.append(studentId);
		builder.append(", companyId=");
		builder.append(companyId);
		builder.append(", city=");
		builder.append(city);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	

}
