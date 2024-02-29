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

import com.crm.dto.CustomerDTO;
import com.crm.service.CustomerService;
import com.crm.utils.JsonUtils;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")	
	public ResponseEntity<CustomerDTO> createCustomer(HttpServletRequest request) {
		CustomerDTO customerDTO = JsonUtils.bindRequestToObject(request, new TypeReference<CustomerDTO>() {});
		return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomer(@PathVariable int id) {
		return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<CustomerDTO> updateCustomer(HttpServletRequest request) {
		CustomerDTO customerDTO = JsonUtils.bindRequestToObject(request, new TypeReference<CustomerDTO>() {});
		return new ResponseEntity<>(customerService.updateCustomer(customerDTO), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> removeCustomer(@PathVariable int id) {
		return new ResponseEntity<>(customerService.removeCustomer(id), HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
	}

}
