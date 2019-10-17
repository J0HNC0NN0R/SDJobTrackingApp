package com.skilldistillery.jobtracking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.Student;
import com.skilldistillery.jobtracking.entities.User;
import com.skilldistillery.jobtracking.repositories.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository sturepo;
	
	@Override
	public Student findByUserName(String username) {
		
		return sturepo.findByUserame(username); 
	}
	
	@Override
	public List<Student> index(){
		return sturepo.findAll();
	}
	
	@Override
	public Student findByStudentId(Integer id) {
		return sturepo.findById(id).get();
	}
	
	@Override
	public Student create(Student student, User user) {
		
		if(student != null && user != null) {
			// TODO setuser to student and flush 
		}
		return student;
		
	}
	
	@Override
	public Student update(Student student) {
		
		// TODO find student 
		// if present update student and update user

		return student;
		
	}
	
	
}
