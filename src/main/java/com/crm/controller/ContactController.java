package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dto.ContactDTO;
import com.crm.service.ContactService;
import com.crm.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/contacts")
@CrossOrigin("*")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@PostMapping("/add")	
	public ResponseEntity<List<ContactDTO>> createContact(HttpServletRequest request) {
		List<ContactDTO> contactDTOs = JsonUtils.bindRequestToObject(request, new TypeReference<List<ContactDTO>>() {});
		return new ResponseEntity<>(contactService.createContact(contactDTOs), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactDTO> getContact(@PathVariable int id) {
		return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ContactDTO> updateContact(HttpServletRequest request) {
		ContactDTO contactDTO = JsonUtils.bindRequestToObject(request, new TypeReference<ContactDTO>() {});
		return new ResponseEntity<>(contactService.updateContact(contactDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Boolean> removeContact(@PathVariable int id) {
		return new ResponseEntity<>(contactService.removeContact(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ContactDTO>> getAllContacts(){
		return new ResponseEntity<>(contactService.getAllContacts(), HttpStatus.OK);
	}

}
