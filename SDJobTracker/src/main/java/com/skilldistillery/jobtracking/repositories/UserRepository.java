package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	public User findByUsername(String username);
	
}
