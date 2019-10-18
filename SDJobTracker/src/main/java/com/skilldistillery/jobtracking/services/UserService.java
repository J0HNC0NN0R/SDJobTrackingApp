package com.skilldistillery.jobtracking.services;

import java.util.List;

import com.skilldistillery.jobtracking.entities.User;

public interface UserService {


	List<User> index();

	User show(Integer id);

	User create(User user);

	User updateUserById(Integer id, User user);

	Boolean deleteUserById(Integer id);


	User findByUserName(String username);

	
	
}
