package com.example.Management.service;

import java.util.List;

import com.example.Management.model.Contact;
import com.example.Management.vo.ContactVO;

public interface ContactService {
	
	public List<Contact> getAllContact();
	
	public Contact saveContact(ContactVO contactVO);
	
	public Contact updateContact(ContactVO contactVO);
	
	public Contact findById(Long id);
	
	public Contact deleteContact(Long id);
	
	public List<Contact> searchContact(String contactSearch);

}
