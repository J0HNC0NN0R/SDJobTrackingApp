package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepo;
	
	@Override
	public User findByUserName(String username) {
		
		return userrepo.findByUsername(username);
	}
	
	@Override
	public List<User> index(){
		return userrepo.findAll();
	}
	@Override
	public User show(Integer id){
		
		Optional<User> user = userrepo.findById(id);
		if (user.isPresent()) {
			
			return user.get();
		} 
		return null;
		
	}
	
	@Override 
	public User create(User user) {
		if(user !=null ) {
			User newUser = userrepo.saveAndFlush(user);
		}
		return user;
	}
	
	@Override 
	public User updateUserById(Integer id,User user ) {
Optional<User> use = userrepo.findById(id);
		
		if(use.isPresent()) {
			User updateUser = use.get();
			
			userrepo.saveAndFlush(updateUser);
		}
		
		return user;
	}
	
	@Override
	public User deleteUserById(Integer id) {
		userrepo.deleteById(id);
		return null;
	}
	
	
} // end Impl
