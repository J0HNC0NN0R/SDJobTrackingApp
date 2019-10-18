package com.skilldistillery.jobtracking.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_desired_location")
public class StudentDesiredLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String city;
	private String state;
//	@Column(name = "student_id")
//	private int studentId;
	@ManyToOne
	@JoinColumn(name="student_id")
	private List<Student> students;
	
	
	public StudentDesiredLocation() {

	}


	public StudentDesiredLocation(int id, String city, String state, List<Student> students) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.students = students;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
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
		StudentDesiredLocation other = (StudentDesiredLocation) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentDesiredLocation [id=");
		builder.append(id);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", students=");
		builder.append(students);
		builder.append("]");
		return builder.toString();
	}

}
