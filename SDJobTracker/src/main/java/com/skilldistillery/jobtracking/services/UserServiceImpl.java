package com.skilldistillery.jobtracking.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
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
		
		User newUser = null;
		if(user !=null ) {
			 newUser = userrepo.saveAndFlush(user);
		}
		return newUser;
	}
	
	@Override 
	public User updateUserById(Integer id,User user ) {
Optional<User> use = userrepo.findById(id);
		User updateUser = null;
		if(use.isPresent()) {
			 updateUser = use.get();
			updateUser.setPassword(encoder.encode(user.getPassword()));
			updateUser.setUsername(user.getUsername());
			updateUser.setEnabled(user.isEnabled());
			userrepo.saveAndFlush(updateUser);
		}
		
		return updateUser;
	}
	
	@Override
	public Boolean deleteUserById(Integer id) {
	
		Optional<User> use = userrepo.findById(id);
		User deleteUser = null;
		if(use.isPresent()) {
			 deleteUser = use.get();
			deleteUser.setEnabled(!deleteUser.isEnabled());
			userrepo.saveAndFlush(deleteUser);
			return true;
		}
		return false;
	}
	
	
} // end Impl
