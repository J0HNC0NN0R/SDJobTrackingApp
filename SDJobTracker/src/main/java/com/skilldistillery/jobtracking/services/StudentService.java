package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;

public interface StudentService {

	Student findByUserName(String username);

	List<Student> index();

	Student findByStudentId(Integer id);

	Student create(Student student, User user);

	Student update(Student student);

}
