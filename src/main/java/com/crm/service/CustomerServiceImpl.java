package com.crm.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crm.dto.CustomerDTO;
import com.crm.exception.CustomerException;
import com.crm.mapper.DTOMapper;
import com.crm.model.Customer;
import com.crm.repository.CustomerRepository;
import com.crm.utils.ErrorCode;
import com.crm.utils.ErrorMessage;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	DTOMapper mapper;
	
	@Autowired
	ErrorMessage errMsg;
	
	@Autowired
	ErrorCode errCode;
	
	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = mapper.toCustomer(customerDTO);
		Customer savedCustomer = customerRepository.save(customer);
		return mapper.toCustomerDTO(savedCustomer);
	}

	@Override
	public CustomerDTO getCustomer(int id) throws CustomerException {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerException(errMsg.getCustomerNotFound() + ": " +id, errCode.getCustomerNotFound(), HttpStatus.NOT_FOUND));
		return mapper.toCustomerDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(customerDTO.getId())
				.orElseThrow(() -> new CustomerException(errMsg.getCustomerNotFound() + " " +customerDTO.getId(), 
						errCode.getCustomerNotFound(), HttpStatus.NOT_FOUND));
		Customer updatedCustomer = mapper.toCustomer(customerDTO);
		updatedCustomer.setId(customerDTO.getId());
		customerRepository.save(updatedCustomer);
		return mapper.toCustomerDTO(updatedCustomer);
	}

	@Override
	public boolean removeCustomer(int id) {
		Customer c = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerException(errMsg.getCustomerNotFound() + " " +id, errCode.getCustomerNotFound(), HttpStatus.NOT_FOUND));
		customerRepository.delete(c);
		return true;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<CustomerDTO> customerDTOs = mapper.toCustomerDTOs(customerRepository.findAll());
		return customerDTOs;
	}

	
}
