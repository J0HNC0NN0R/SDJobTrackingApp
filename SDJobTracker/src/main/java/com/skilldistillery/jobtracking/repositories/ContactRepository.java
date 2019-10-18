package com.skilldistillery.jobtracking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.jobtracking.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
