package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contacts")
	public Contact createCOntact(@RequestBody Contact contact) {
		return contactService.create(contact);
	}
	
	@GetMapping("/contacts")
	public List<Contact> readAll(){
		return contactService.readContacts();
	}
	
	@GetMapping("/contacts/{id}")
	public Optional<Contact> readContact(@PathVariable("id") int id) {
		return contactService.readById(id);
	}
	
	@DeleteMapping("/contacts/{id}")
	public String delete(@PathVariable("id") int id) {
		contactService.delete(id);
		return "Contact deleted at id "+id;
	}
	
	@PutMapping("/contacts/{id}")
	public Contact update(@PathVariable("id") int id , @RequestBody Contact contact) {
		return contactService.update(contact, id);
	}
	
	@GetMapping("/contacts/name/{name}")
	public List<Contact> findByfName(@PathVariable("name") String name) {
		return contactService.readByName(name);
	}
	
	@GetMapping("/contacts/lastname/{lname}")
	public List<Contact> findBylName(@PathVariable("lname") String lname) {
		return contactService.readByLastName(lname);
	}
	
	@GetMapping("contacts/email/{email}")
	public List<Contact> findByEmail(@PathVariable("email") String email) {
		return contactService.readByEmail(email);
	}
}
