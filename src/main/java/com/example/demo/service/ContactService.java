package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact create(Contact c) {
		return contactRepository.save(c);
	}
	
	public List<Contact> readContacts(){
		List<Contact> list= contactRepository.findAll();
		return list;
	}
	
	public Optional<Contact> readById(int id) {
		Optional<Contact> contact=null;
		contact=contactRepository.findById(id);
		return contact;
	}
	
	public void delete(int id) {
		contactRepository.deleteById(id);
	}
	
	public Contact update(Contact contact , int id) {
		return contactRepository.save(contact);
	}
	
	public List<Contact> readByName(String name) {
		List<Contact> contact=null;
		contact=contactRepository.findByFirstName(name);
		return contact;
	}
	
	public List<Contact> readByLastName(String lname) {
		List<Contact> contact=null;
		contact=contactRepository.findByLastName(lname);
		return contact;
	}
	
	public List<Contact> readByEmail(String email) {
		List<Contact> contact=null;
		contact=contactRepository.findByEmail(email);
		return contact;
	}
}
