package com.crm.controller;

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

import com.crm.dto.UserDTO;
import com.crm.service.UserService;
import com.crm.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")	
	public ResponseEntity<UserDTO> registerUser(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getContact(@PathVariable int id) {
		return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserDTO> updateContact(HttpServletRequest request) {
		UserDTO userDTO = JsonUtils.bindRequestToObject(request, new TypeReference<UserDTO>() {});
		return new ResponseEntity<>(userService.updateUser(userDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Boolean> removeUser(@PathVariable int id) {
		return new ResponseEntity<>(userService.removeUser(id), HttpStatus.OK);
	}
}
