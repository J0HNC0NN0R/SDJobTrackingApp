package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.User;

public interface StudentService {

	User findByUserName(String username);

	List<Student> index();

}
