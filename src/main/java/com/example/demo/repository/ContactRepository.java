package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact , Integer>{
	@Query("select c from Contact c where c.first_name=?1")
	public List<Contact>findByFirstName(String fname);
	@Query("select c from Contact c where c.last_name=?1")
	public List<Contact> findByLastName(String lname); 
	@Query("select c from Contact c where c.email=?1")
	public List<Contact> findByEmail(String email);
}
