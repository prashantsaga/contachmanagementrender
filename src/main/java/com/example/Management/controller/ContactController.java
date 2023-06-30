package com.example.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Management.service.ContactService;
import com.example.Management.vo.ContactVO;

@RestController
@CrossOrigin
public class ContactController {
	@Autowired
	ContactService contactService;
	
	@GetMapping("/getAllContact")
	public ResponseEntity<?> getAllContact() {
		return ResponseEntity.ok(contactService.getAllContact());
	}
	
	@PostMapping("/saveContact")
	public ResponseEntity<?> saveContact(@RequestBody ContactVO contactVO) {
		return ResponseEntity.ok(contactService.saveContact(contactVO));
	}

	
	@PutMapping("/updateContact")
	public ResponseEntity<?> updateContact(@RequestBody ContactVO contactVO) {
		return ResponseEntity.ok(contactService.updateContact(contactVO));
	}

	
	@GetMapping("/findById")
	public ResponseEntity<?> findById(@RequestParam Long id) {
		return ResponseEntity.ok(contactService.findById(id));
	}

	
	@DeleteMapping("/deleteContact")
	public ResponseEntity<?> deleteContact(@RequestParam Long id) {
		return ResponseEntity.ok(contactService.deleteContact(id));
	}

	@GetMapping("/searchContact")
	public ResponseEntity<?> searchContact(@RequestParam String contactSearch) {
		return ResponseEntity.ok(contactService.searchContact(contactSearch));
	}


}
