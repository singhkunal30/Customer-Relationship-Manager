package com.crm.service;

import java.util.List;

import com.crm.dto.CustomerDTO;

public interface CustomerService {
	
	CustomerDTO createCustomer(CustomerDTO customerDTO);
	
	CustomerDTO getCustomer(int id);
	
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	
	boolean removeCustomer(int id);
	
	List<CustomerDTO> getAllCustomers();
	
}
