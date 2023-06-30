package com.example.Management.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Management.model.Contact;
import com.example.Management.repo.ContactRepo;
import com.example.Management.service.ContactService;
import com.example.Management.vo.ContactVO;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	ContactRepo contactRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public List<Contact> getAllContact() {
		return contactRepo.findAll();
	}

	@Override
	public Contact saveContact(ContactVO contactVO) {
		return contactRepo.saveAndFlush(mapper.convertValue(contactVO, Contact.class));
	}

	@Override
	public Contact updateContact(ContactVO contactVO) {
		return contactRepo.saveAndFlush(mapper.convertValue(contactVO, Contact.class));
	}

	@Override
	public Contact findById(Long id) {
		return contactRepo.findById(id).get();
	}

	@Override
	public Contact deleteContact(Long id) {
		Contact temp = contactRepo.findById(id).get();
		contactRepo.delete(temp);
		return temp;
	}

	@Override
	public List<Contact> searchContact(String contactSearch) {
		return contactRepo.getAllSearchContact(contactSearch);
	}

}
