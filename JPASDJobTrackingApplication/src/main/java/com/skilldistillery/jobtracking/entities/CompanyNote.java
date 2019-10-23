package com.skilldistillery.jobtracking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "company_note")
public class CompanyNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String body;
//	@Column(name = "company_id")
//	private int companyId;
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonIgnore
	private Company company;
//	@Column(name = "student_id")
//	private int studentId;
	@ManyToOne
	@JoinColumn(name="student_id")
	@JsonIgnore
	private Student student;
	
	public CompanyNote() {
		
	}

	public CompanyNote(int id, String title, String body, Company company, Student student) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.company = company;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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

	

}