package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	ContactService ContactService;
	
	@PostMapping("/add")	
	public ResponseEntity<ContactDTO> createContact(HttpServletRequest request) {
		ContactDTO ContactDTO = JsonUtils.bindRequestToObject(request, new TypeReference<ContactDTO>() {});
		return new ResponseEntity<>(ContactService.createContact(ContactDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContactDTO> getContact(@PathVariable int id) {
		return new ResponseEntity<>(ContactService.getContact(id), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<ContactDTO> updateContact(HttpServletRequest request) {
		ContactDTO ContactDTO = JsonUtils.bindRequestToObject(request, new TypeReference<ContactDTO>() {});
		return new ResponseEntity<>(ContactService.updateContact(ContactDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> removeContact(@PathVariable int id) {
		return new ResponseEntity<>(ContactService.removeContact(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ContactDTO>> getAllContacts(){
		return new ResponseEntity<>(ContactService.getAllContacts(), HttpStatus.OK);
	}

}
